package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.EmployeeTable;
import dao.LoginDao;
import dao.LoginDaoImplementation;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginDao loginDao;
	RequestDispatcher requestDispatcher = null;

	public LoginController() {
		super();
		loginDao = new LoginDaoImplementation();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeTable employeeTable = new EmployeeTable();
		employeeTable.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
		employeeTable.setPassword(request.getParameter("password"));
		Integer employee_id = employeeTable.getEmployee_id();
		String password = employeeTable.getPassword();
		String resultString = loginDao.loginCheck(employee_id, password);
		if (resultString.equals("true")) {
			String name = loginDao.nameRetrieve(employee_id, password);
			String employee_idString = Integer.toString(employeeTable.getEmployee_id());
			session.setAttribute("employee_id", employee_idString);
			request.setAttribute("name", name);
			requestDispatcher = request.getRequestDispatcher("/views/homepage.jsp");
			requestDispatcher.forward(request, response);
			response.sendRedirect("/servlethibernate1/views/homepage.jsp");
		}
		if (resultString.equals("false")) {
			response.sendRedirect("index.jsp?status=false");
		}

	}

}
