package controllers.foods;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Food;
import utils.DBUtil;

/**
 * Servlet implementation class FoodsIndexServlet
 */
@WebServlet("/foods/index")
public class FoodsIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodsIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();



        List<Food> foods = (List<Food>)em.createNamedQuery("getAllFoods", Food.class).getResultList();
        // 現在日時の LocatTimeインスタンスを取得
        LocalDate now = LocalDate.now();
        request.setAttribute("foods", foods);
        request.setAttribute("now", now);
        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/foods/index.jsp");
        rd.forward(request, response);
    }

}
