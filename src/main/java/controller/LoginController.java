
package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

import repository.UserRepository;
import model.User;

public class LoginController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)
                          throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserRepository repo = new UserRepository();

        User user = repo.login(email, password);

        if(user != null){

            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            if(user.getRole().equals("admin")){
                res.sendRedirect("adminDashboard.jsp");
            }
            else if(user.getRole().equals("teacher")){
                res.sendRedirect("teacherDashboard.jsp");
            }
            else{
                res.sendRedirect("studentDashboard.jsp");
            }

        }else{
            res.sendRedirect("login.jsp?error=1");
        }
    }
}