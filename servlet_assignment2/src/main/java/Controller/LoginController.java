package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.EmployeeTable;
import dao.LoginDao;
import dao.LoginDaoImplementation;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	LoginDao loginDao;
	
	public LoginController() {
        super();
        loginDao = new LoginDaoImplementation();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = null;
		
		
		HttpSession session = request.getSession();
		EmployeeTable employeeTable = new EmployeeTable();
		employeeTable.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
		employeeTable.setPassword(request.getParameter("password"));
		Integer employee_id = employeeTable.getEmployee_id();
		String password = employeeTable.getPassword();
		String resultString = loginDao.loginCheck(employee_id, password);
		if (resultString.equals("true")) {
			String employee_idString = Integer.toString(employeeTable.getEmployee_id());
			session.setAttribute("employee_id", employee_idString);
			response.sendRedirect("/servlet_assignment2/views/homepage.jsp");
		} 
		if (resultString.equals("false")) {
			response.sendRedirect("index.jsp?status=false");
		}
		
	}

}
