package controllers.foods;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Food;
import models.User;
import models.validators.FoodValidator;
import utils.DBUtil;

/**
 * Servlet implementation class FoodsCreateServlet
 */
@WebServlet("/foods/create")
public class FoodsCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodsCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u_token  = request.getParameter("u_token");
        if(u_token != null && u_token.equals(request.getSession().getId()));
            User login_user = (User)request.getSession().getAttribute("login_user");
            EntityManager em = DBUtil.createEntityManager();

            Food f = new Food();

            f.setFood_name(request.getParameter("food_name"));
            String amount = request.getParameter("amount");
            f.setAmount(Integer.parseInt(amount));
            // f.setAmount(Integer.parseInt(request.getParameter("amount")));

            String open_flag = request.getParameter("open_flag");
            System.out.println(open_flag + "open_flag");
            String time_limit = request.getParameter("time_limit");
            System.out.println(time_limit + "time_limit");
           // f.setOpen_flag(request.getParameter("open_flag"));
           // f.setLimit(Date.(request.getParameter("limit")));

            f.setOpen_flag(Integer.parseInt(open_flag));
            f.setLimit(java.sql.Date.valueOf(time_limit));
            f.setUser(login_user);

           System.out.println("***");
           System.out.println("食材名: " + f.getFood_name());
           System.out.println("数量: " + f.getAmount());
           System.out.println("開封状態: " + f.getOpen_flag());
           System.out.println("賞味期限: " + f.getTime_limit());
           System.out.println("ユーザー名: " + f.getUser().getName());


           List<String> errors = FoodValidator.validate(f);
           if(errors.size() > 0) {
               em.close();

               request.setAttribute("u_token", request.getSession().getId());
               request.setAttribute("food", f);
               request.setAttribute("errors", errors);

               RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/foods/new.jsp");
               rd.forward(request, response);
           } else {
           em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            em.close();

            response.sendRedirect(request.getContextPath() + "/foods/index");

           }

    }

}
