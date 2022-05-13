package member;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MemberBean;
import dao.DAOException;
import dao.MemberEntryDAO;

@WebServlet("/MemberEntryServlet")
public class MemberEntryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			// パラメータの解析
			String action = request.getParameter("action");
			// モデルDAOを生成
			MemberEntryDAO dao = new MemberEntryDAO();

			MemberBean bean = new MemberBean();
			if (action.equals("addMember")) {
				bean.setName(request.getParameter("name"));
				bean.setAddress(request.getParameter("address"));
				bean.setTel(request.getParameter("tel"));
				bean.setMail(request.getParameter("mail"));
				bean.setBirthday(Date.valueOf("birthday"));
				bean.setPassword(request.getParameter("password"));

				dao.addMember(bean);
				gotoPage(request, response, "/MemberManage.jsp");

			}
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "MemberEntryServletErr");
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