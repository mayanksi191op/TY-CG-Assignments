package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EmployeeTable;
import dao.EmployeeDao;
import dao.EmployeeDaoImplementation;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher requestDispatcher = null;
	EmployeeDao employeeDao = null;
	public SearchController() {
        super();
        employeeDao = new EmployeeDaoImplementation();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employee_idString = request.getParameter("employee_id");
		System.out.println(employee_idString);
		int employee_id = Integer.parseInt(employee_idString);
		EmployeeTable employee = employeeDao.get(employee_id);
		request.setAttribute("employee", employee);
		requestDispatcher = request.getRequestDispatcher("/views/displaysearch.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
