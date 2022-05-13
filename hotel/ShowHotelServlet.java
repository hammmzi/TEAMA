package hotel;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ShowHotelServlet")
public class ShowHotelServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
       
    }

    private void gotoPage(HttpServletRequest request,
            HttpServletResponse response, String page) throws ServletException,
            IOException {
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

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