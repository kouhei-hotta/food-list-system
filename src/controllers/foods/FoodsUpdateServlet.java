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
 * Servlet implementation class FoodsUpdateServlet
 */
@WebServlet("/foods/update")
public class FoodsUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodsUpdateServlet() {
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
            // Food f = new Food();
            Food f = em.find(Food.class, Integer.parseInt(request.getParameter("id")));
            f.setFood_name(request.getParameter("food_name"));
            // String amount = request.getParameter("amount");
            // f.setAmount(Integer.parseInt(amount));
            f.setAmount(request.getParameter("amount"));
            String open_flag_str = request.getParameter("open_flag");
            System.out.println(open_flag_str + "open_flag");
            String time_limit = request.getParameter("time_limit");
            System.out.println(time_limit + "time_limit");
           // f.setOpen_flag(request.getParameter("open_flag"));
           // f.setLimit(Date.(request.getParameter("limit")));
            Integer open_flag = 0;
            try{
                open_flag = Integer.parseInt(open_flag_str);
            }catch(Exception e){
                open_flag = 2;
            }
//            if(!time_limit.matches("^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$")){
//              time_limit = "0000-00-00";
//            }
            if(time_limit.equals("")){
                time_limit = "1972-01-01";
            }
            f.setOpen_flag(open_flag);
            f.setLimit(java.sql.Date.valueOf(time_limit));
            f.setUser(login_user);
           List<String> errors = FoodValidator.validate(f);
           if(errors.size() > 0) {
               em.close();

               request.setAttribute("u_token", request.getSession().getId());
               request.setAttribute("food", f);
               request.setAttribute("errors", errors);

               RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/foods/edit.jsp");
               rd.forward(request, response);
           } else {
            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();
            request.getSession().setAttribute("flush", "更新が完了しました。");

            request.getSession().removeAttribute("food_id");


            response.sendRedirect(request.getContextPath() + "/foods/index");
           }
        }
    }


