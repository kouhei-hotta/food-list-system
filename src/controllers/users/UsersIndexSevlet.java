package controllers.users;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class UsersIndexSevlet
 */
@WebServlet("/users/index")
public class UsersIndexSevlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersIndexSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        int page = 1;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(NumberFormatException u) { }
        List<User> users = em.createNamedQuery("getAllUsers", User.class)
                             .setFirstResult(10 * (page -1))
                             .setMaxResults(10)
                             .getResultList();

        long users_count = (long)em.createNamedQuery("getUsersCount",Long.class)
                                   .getSingleResult();

        em.close();

        request.setAttribute("users",users);
        request.setAttribute("users_count", users_count);
        request.setAttribute("page",page);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/users/index.jsp");
        rd.forward(request, response);
    }

}
