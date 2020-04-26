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

import bean.EmployeeTable;
import dao.EmployeeDao;
import dao.EmployeeDaoImplementation;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher requestDispatcher = null;
	EmployeeDao employeeDao = null;

	public EmployeeController() {
		employeeDao = new EmployeeDaoImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "LIST";
		}

		switch (action) {
		case "LIST":
			listEmployee(request, response);
			break;
		case "EDIT":
			getSingleUser(request, response);
			break;
		case "DELETE":
			deleteUser(request, response);
			break;
		default:
			listEmployee(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		System.out.println(employee_id);

			employeeTable.setEmployee_id(Integer.parseInt(employee_id));
			if (employeeDao.update(employeeTable)) {
				request.setAttribute("message", "update successfully");
			}
		
		listEmployee(request, response);
	}


	public void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<EmployeeTable> list = new ArrayList<EmployeeTable>();
		list = employeeDao.get();
		for (EmployeeTable employeeTable : list) {
			System.out.println(employeeTable.toString());
		}
		request.setAttribute("list", list);
		requestDispatcher = request.getRequestDispatcher("/views/employeelist.jsp");
		requestDispatcher.forward(request, response);

	}

	public void getSingleUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside getSingleUser");
		String employee_id = request.getParameter("employee_id");
		EmployeeTable employee = employeeDao.get(Integer.parseInt(employee_id));
		request.setAttribute("employee", employee);
		requestDispatcher = request.getRequestDispatcher("/views/employeeupdate.jsp");
		requestDispatcher.forward(request, response);
	}

	public void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String employee_id = request.getParameter("employee_id");
		System.out.println(employee_id);
		if (employeeDao.delete(Integer.parseInt(employee_id))) {
			request.setAttribute("NOTIFICATION", "Employee Deleted Successfully!");
		}
		listEmployee(request, response);
	}

//	public static void main(String[] args) {
//		EmployeeController controller =  new EmployeeController();
//		
//		controller.listEmployee(request, response);
//	}
}
