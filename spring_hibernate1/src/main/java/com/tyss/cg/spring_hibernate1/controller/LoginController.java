package com.tyss.cg.spring_hibernate1.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tyss.cg.spring_hibernate1.bean.EmployeeTable;
import com.tyss.cg.spring_hibernate1.dao.LoginDao;

import javassist.expr.NewArray;

//@Controller
public class LoginController {
	RequestDispatcher requestDispatcher = null;

	
	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private EmployeeTable employeeTable;
	
	@RequestMapping("login")
	public String Login(Model model) {
		model.addAttribute("employeetable", new EmployeeTable());
		return "homepage";
	}
	
	@RequestMapping("employee_redirect")
	public String employeeGo(Model model) {
		return "employee";
	}
	
	@RequestMapping("login1")
	public String LoginFunc(@ModelAttribute("employeetable") EmployeeTable employeeTable, Model model) {
		//HttpSession session = request.getSession();
		//EmployeeTable employeeTable = new EmployeeTable();
		//employeeTable.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
		//employeeTable.setPassword(request.getParameter("password"));
		Integer employee_id = employeeTable.getEmployee_id();
		String password = employeeTable.getPassword();
		String resultString = loginDao.loginCheck(employeeTable);
		if (resultString.equals("true")) {
//			String name = loginDao.nameRetrieve(employee_id, password);
//			String employee_idString = Integer.toString(employeeTable.getEmployee_id());
			EmployeeController controller = new EmployeeController();
			
//			model.addAttribute("employee_id", employee_idString);
//			model.addAttribute("name", name);
			
//			session.setAttribute("employee_id", employee_idString);
//			request.setAttribute("name", name);
//			requestDispatcher = request.getRequestDispatcher("/views/homepage.jsp");
//			requestDispatcher.forward(request, response);
//			response.sendRedirect("/servlethibernate1/views/homepage.jsp");
			return employeeGo(model);
		}
		if (resultString.equals("false")) {
			return "index.jsp?status=false";
		}
		return Login(model);
	}
}
