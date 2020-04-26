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

@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	RequestDispatcher requestDispatcher = null;
	EmployeeController employeeController = null;
	EmployeeDao employeeDao = null;
	public AddEmployee() {
        super();
        employeeDao = new EmployeeDaoImplementation();
        employeeController = new EmployeeController();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employee_id = request.getParameter("employee_id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String designation = request.getParameter("designation");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		String joining_date = request.getParameter("joining_date");
		String dept_id = request.getParameter("dept_id");
		String salary = request.getParameter("salary");
		String mobile = request.getParameter("mobile");
		String manager_id = request.getParameter("manager_id");
		String password2 = request.getParameter("password2");
		
		
		EmployeeTable employeeTable = new EmployeeTable();
		employeeTable.setDept_id(Integer.parseInt(dept_id));
		employeeTable.setDesignation(designation);
		employeeTable.setDob(dob);
		employeeTable.setName(name);
		employeeTable.setEmail(email);
		employeeTable.setJoining_date(joining_date);
		employeeTable.setManager_id(Integer.parseInt(manager_id));
		employeeTable.setMobile(mobile);
		employeeTable.setSalary(salary);
		employeeTable.setPassword(password);
		employeeTable.setEmployee_id(Integer.parseInt(employee_id));
		
		if (password.equals(password2)) {
			if (employeeDao.save(employeeTable)) {
				request.setAttribute("message", "saved successfully");
			}
			response.sendRedirect("/servlethibernate1/EmployeeController?action=LIST");
		}	else {
			String incorrectpass = "password not matching...";
			request.setAttribute("incorrectpass", incorrectpass);
			requestDispatcher = request.getRequestDispatcher("/views/employeeadd.jsp");
			requestDispatcher.forward(request, response);
		}
		
	
	}

}
