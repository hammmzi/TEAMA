package hotel;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.HotelBean;
import dao.DAOException;
import dao.HotelDeleteDAO;

@WebServlet("/HotelDeleteServlet")
public class HotelDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			// パラメータ解析
			String action = request.getParameter("action");
			// モデルのDAOを生成
			HotelDeleteDAO dao = new HotelDeleteDAO();
			
			// 宿情報を削除
			if (action.equals("delete")) {
				try {
					String id = request.getParameter("id");
					// 未入力チェック
					if (id == null || id.length() == 0) {
						request.setAttribute("message", "宿IDを入力してください。");
						gotoPage(request, response, "/errInternal.jsp");
						return;
					} else if (id.length() > 3) {
						request.setAttribute("message", "宿IDは3桁以内を入力してください。");
						gotoPage(request, response, "/errInternal.jsp");
						return;
					} else {
						int ID = Integer.parseInt(id);
						dao.deleteHotel(ID);
						// 削除後全レコード表示
						List<HotelBean> list = dao.find();
						// Listをリクエストスコープに入れてJSPにフォワード
						request.setAttribute("hotels", list);
						gotoPage(request, response, "/HotelManage.jsp");
					}
				} catch (NumberFormatException e) {
					request.setAttribute("message", "数字を入力してください。");
					gotoPage(request, response, "/errInternal.jsp");
				}
			} else {
				// actionの値が不正
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}