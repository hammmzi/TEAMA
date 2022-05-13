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
import dao.HotelSearchDAO;

@WebServlet("/HotelSearchServlet")
public class HotelSearchServlet extends HttpServlet {

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			// パラメータの解析
			String action = request.getParameter("action");
			// モデルのDAOを生成
			HotelSearchDAO dao = new HotelSearchDAO();
			// パラメータなしの場合は全レコード表示
			if (action == null || action.length() == 0) {
				List<HotelBean> list = dao.find();
				// Listをリクエストスコープに入れてJSPへフォーワードする
				request.setAttribute("items", list);
				gotoPage(request, response, "/HotelManage.jsp");
			} else if (action.equals("searchma")) {
		//全部読み取る（めんどいけど書くの必須）
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String region = request.getParameter("region");
				String address = request.getParameter("address");
				
				//HotelBeanをnewで呼び込む
//				HotelBean HB = new HotelBean(id,name,region,address);
				
							// 修正後、全レコード表示
				List<HotelBean> list = 	dao.findHotelByMa( region,  address,  id,  name);
				// Listをリクエストスコープに入れてJSPへフォーワードする
				request.setAttribute("HotelList", list);
				gotoPage(request, response, "/HotelManage.jsp");
			} else if (action.equals("searchme")) {
				//全部読み取る（めんどいけど書くの必須）
						int min = Integer.parseInt(request.getParameter("min"));
						int max = Integer.parseInt(request.getParameter("max"));
						int room = Integer.parseInt(request.getParameter("room"));
						String region = request.getParameter("region");
						String name = request.getParameter("name");
						String in = request.getParameter("in");
						String out = request.getParameter("out");

						
						//HotelBeanをnewで呼び込む
//						HotelBean HB = new HotelBean(min, max, room,region,name, in, out);
						
									// 修正後、全レコード表示
						List<HotelBean> list = 	dao.findHotelByMe(min, max, room,region,name, in, out);
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

	//通常のログイン処理
	//DAOを作る
	//メソッドを呼ぶときにフォームの情報を渡す
	//ログイン出来たらMemberBean、出来なかったらnull
	
	


//    private void gotoPage(HttpServletRequest request,
//            HttpServletResponse response, String page) throws ServletException,
//            IOException {
//        RequestDispatcher rd = request.getRequestDispatcher(page);
//        rd.forward(request, response);
//    }
//
//    public void init() throws ServletException {
//        try {
//            // カテゴリ一覧は最初にアプリケーションスコープへ入れる
//            ItemDAO dao = new ItemDAO();
//            List<CategoryBean> list = dao.findAllCategory();
//            getServletContext().setAttribute("categories", list);
//        } catch (DAOException e) {
//            e.printStackTrace();
//            throw new ServletException();
//        }
//    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}