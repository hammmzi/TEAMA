package hotel;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.HotelBean;
import dao.DAOException;
import dao.HotelEntryDAO;

@WebServlet("/HotelEntryServlet")
public class HotelEntryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			// パラメータの解析
			String action = request.getParameter("action");
			// モデルDAOを生成
			HotelEntryDAO dao = new HotelEntryDAO();

			HotelBean bean = new HotelBean();
			if (action.equals("addHotel")) {
				bean.setId(Integer.parseInt(request.getParameter("id")));
				bean.setName(request.getParameter("name"));
				bean.setRegion(request.getParameter("region"));
				bean.setAddress(request.getParameter("address"));
				bean.setTel(request.getParameter("tel"));
				bean.setPlan1(request.getParameter("plan1"));
				bean.setPlan2(request.getParameter("plan2"));
				bean.setIn1(Time.valueOf("in1"));
				bean.setOut1(Time.valueOf("out1"));
				bean.setIn2(Time.valueOf("in2"));
				bean.setOut2(Time.valueOf("out2"));
				bean.setPrice1(Integer.parseInt(request.getParameter("price1")));
				bean.setPrice2(Integer.parseInt(request.getParameter("price2")));
				bean.setRoom1(Integer.parseInt(request.getParameter("room1")));
				bean.setRoom2(Integer.parseInt(request.getParameter("room2")));

				dao.addHotel(bean);
				gotoPage(request, response, "/HotelManage.jsp");
			}

		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "HotelEntryServletErr");
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