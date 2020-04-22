package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import dao.LoginDao;
import dao.LoginDaoImplementation;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginDao loginDao = null;
	
	public LoginController() {
        super();
        loginDao = new LoginDaoImplementation();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserBean user = new UserBean();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		
		String result = loginDao.loginCheck(user);
		
		if (result.equals("true")) {
			session.setAttribute("email", user.getEmail());
			response.sendRedirect("/servletassignmentdynamic/views/homepage.jsp");
		}
		
		if (result.equals("false")) {
			response.sendRedirect("index.jsp?status=false");
		}
		
		if (result.equals("error")) {
			response.sendRedirect("index.jsp?status=error");
		}
		
	}

}
