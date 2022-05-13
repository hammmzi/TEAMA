package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MemberBean;
import dao.DAOException;
import dao.MemberSearchDAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//ログイン済みかどうかチェックする
		//すでに作成済みのセッション領域の取得
		
		//ログイン時はメールとPWを取得する
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		//未入力チェック
		if (mail ==  null || mail.length() == 0 || password == null || password.length() == 0) {
			request.setAttribute("message", "*未入力の項目があります");
			gotoPage(request, response, "/Login.jsp");
			return;
		}
		//通常のログイン処理
		//DAOを作る
		//メソッドを呼ぶときにフォームの情報を渡す
		//ログイン出来たらMemberBean、出来なかったらnull
		try {
			MemberSearchDAO dao = new MemberSearchDAO();
			MemberBean member = dao.logincheck(mail, password);
			if (member == null) {
				request.setAttribute("message", "*メールアドレスまたはパスワードが間違っています！");
				gotoPage(request, response, "/Login.jsp");
				return;
			}
			//メンバーをセッションに入れる
			HttpSession session = request.getSession();
			session.setAttribute("loginMember",member);
			//loginMember が教科書P79のisLoginに相当
//			loginMember にmail password を保持している
			
			//完了ページに移動
	    	gotoPage(request, response, "/LoginFinish.jsp");
			return;
			
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "システムエラー");
			gotoPage(request, response, "/errInternal.jsp");
			return;
		}
	}
	
	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}