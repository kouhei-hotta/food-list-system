package controllers.foods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Food;

/**
 * Servlet implementation class FoodsNewSevlet
 */
@WebServlet("/foods/new")
public class FoodsNewSevlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodsNewSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("u_token",request.getSession().getId());
        request.setAttribute("food", new Food());


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/foods/new.jsp");
        rd.forward(request, response);
    }

}
