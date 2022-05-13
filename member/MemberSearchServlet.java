package member;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MemberBean;
import dao.DAOException;
import dao.MemberSearchDAO;


@WebServlet("/MemberSearchServlet")
public class MemberSearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    try {
		request.setCharacterEncoding("UTF-8");
		// パラメータの解析
		String action = request.getParameter("action");
		// モデルのDAOを生成
		MemberSearchDAO dao = new MemberSearchDAO();
		// パラメータなしの場合は全レコード表示
		if (action == null || action.length() == 0) {
			List<MemberBean> list = dao.find();
			// Listをリクエストスコープに入れてJSPへフォーワードする
			request.setAttribute("MemberList", list);
			gotoPage(request, response, "/MemberManage.jsp");
		}else if (action.equals("search")) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			String mail = request.getParameter("mail");
//			System.out.println(name + address + tel + mail + request.getParameter("birthday"));
			String bd = request.getParameter("birthday");
			Date birthday = null;
			if(bd != null && 0 != bd.length()) {
				birthday = Date.valueOf(bd);
			}
			List<MemberBean> list =dao.findMember(name, address, tel, mail, birthday);
			// Listをリクエストスコープに入れてJSPへフォーワードする
			request.setAttribute("MemberList", list);
			gotoPage(request, response, "/MemberManage.jsp");
		} else {
			request.setAttribute("message", "正しく操作してください。");
			gotoPage(request, response, "/errInternal.jsp");
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

		
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}