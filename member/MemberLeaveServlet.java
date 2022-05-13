package member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MemberBean;
import dao.DAOException;
import dao.MemberLeaveDAO;

//退会
@WebServlet("/MemberLeaveServlet")
public class MemberLeaveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Login　session check？
		HttpSession session = request.getSession(false);
		if (session == null) {
			// session objectがない
			request.setAttribute("message", "セッションが切れています。もう一度ログインしてください。");
			gotoPage(request, response, "/errInternal.jsp");
			return;
		}
		MemberBean member = (MemberBean) session.getAttribute("loginMember");
		if (member == null) {
			request.setAttribute("message", "正しくない操作です。");
			gotoPage(request, response, "/errInternal.jsp");
			return;
		}

		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			MemberLeaveDAO dao = new MemberLeaveDAO();
			//管理者と会員　分岐してページ移動
			String url = "";
			if (action.equals("memberLeave")) {
				// ログインした人の情報をセッションから持ってくる
				// MemberBean bean = new MemberBean();
				int cn = 0;
				int status = member.getStatus();
				
				// status 1
				// int cn = bean.getCn();
				if(status == 1) {
					cn = member.getCn();
					url = "/LeaveFinsh.jsp";
				}else if (status == 0) {
					// status 0
					// 管理者フォームでもらってくる
					// 2の人退会 test int status = 0; int cn = 2;
					cn = Integer.parseInt(request.getParameter("cn"));
					url = "/MemberMange.jsp";
				}

				// statusを2に変更
				dao.updateMemberStatus(cn, 2);
				List<MemberBean> list = dao.find();
				request.setAttribute("memberList", list);
				gotoPage(request, response, url);				

			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/errInternal.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}