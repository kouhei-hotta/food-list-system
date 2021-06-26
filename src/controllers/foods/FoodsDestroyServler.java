package controllers.foods;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Food;
import utils.DBUtil;

/**
 * Servlet implementation class FoodsDestroyServler
 */
@WebServlet("/foods/destroy")
public class FoodsDestroyServler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodsDestroyServler() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u_token = request.getParameter("u_token");
        if(u_token != null && u_token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Food f = em.find(Food.class, (Integer)(request.getSession().getAttribute("food_id")));

            em.getTransaction().begin();
            em.remove(f);
            em.getTransaction().commit();
            em.close();
            request.getSession().removeAttribute("food_id");
            request.getSession().setAttribute("flush", "削除が完了しました。");

            response.sendRedirect(request.getContextPath() + "/foods/index");
        }
    }

}
