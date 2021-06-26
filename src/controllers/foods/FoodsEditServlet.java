package controllers.foods;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Food;
import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class FoodsEditServlet
 */
@WebServlet("/foods/edit")
public class FoodsEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodsEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Food f = em.find(Food.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        User login_user = (User)request.getSession().getAttribute("login_user");
        if(f != null && login_user.getId() == f.getUser().getId()) {
            request.setAttribute("food", f);
            request.setAttribute("u_token", request.getSession().getId());
            request.getSession().setAttribute("food_id", f.getId());
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/foods/edit.jsp");
        rd.forward(request, response);
    }

}
