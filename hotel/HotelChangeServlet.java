package hotel;

import java.io.IOException;
import java.sql.Time;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.HotelBean;
import dao.DAOException;
import dao.HotelChangeDAO;

/**
 * Servlet implementation class HotelChangeServlet
 */
@WebServlet("/HotelChangeServlet")
public class HotelChangeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			// パラメータの解析
			String action = request.getParameter("action");
			// モデルのDAOを生成
			HotelChangeDAO dao = new HotelChangeDAO();
			// パラメータなしの場合は全レコード表示
			if (action == null || action.length() == 0) {
				List<HotelBean> list = dao.find();
				// Listをリクエストスコープに入れてJSPへフォーワードする
				request.setAttribute("items", list);
				gotoPage(request, response, "/HotelManage.jsp");

			} else if (action.equals("update")) {
				//全部読み取る（めんどいけど書くの必須）
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String region = request.getParameter("region");
				String address = request.getParameter("address");
				String tel = request.getParameter("tel");
				String plan1 = request.getParameter("plan1");
				String plan2 = request.getParameter("plan2");
				int price1 = Integer.parseInt(request.getParameter("price1"));
				int price2 = Integer.parseInt(request.getParameter("price2"));
				Time in1 = Time.valueOf(request.getParameter("in1")+":00");
				Time out1 = Time.valueOf(request.getParameter("out1")+":00");
				Time in2 = Time.valueOf(request.getParameter("in2")+":00");
				Time out2 = Time.valueOf(request.getParameter("out2")+":00");
				int room1 = Integer.parseInt(request.getParameter("room1"));
				int room2 = Integer.parseInt(request.getParameter("room2"));
				//HotelBeanをnewで呼び込む
				HotelBean HB = new HotelBean(id,name,region,address,tel,plan1,
						plan2,price1,price2,in1,out1,in2,out2,room1,room2);
				
				dao.updateHotel(HB);
				// 修正後、全レコード表示
				List<HotelBean> list = dao.find();
				// Listをリクエストスコープに入れてJSPへフォーワードする
				request.setAttribute("HotelList", list);
				gotoPage(request, response, "/HotelManage.jsp");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
