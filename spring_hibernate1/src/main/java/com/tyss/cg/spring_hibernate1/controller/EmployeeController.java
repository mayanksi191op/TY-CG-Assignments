package com.tyss.cg.spring_hibernate1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyss.cg.spring_hibernate1.bean.EmployeeTable;
import com.tyss.cg.spring_hibernate1.dao.EmployeeDao;
import com.tyss.cg.spring_hibernate1.dao.LoginDao;

import javassist.expr.NewArray;

@Controller
public class EmployeeController {

	RequestDispatcher requestDispatcher = null;

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private EmployeeTable employeeTable;

	@RequestMapping("employee")
	public String listEmployee(Model model) {
		List<EmployeeTable> list = new ArrayList<EmployeeTable>();
		list = employeeDao.get();
		for (EmployeeTable employeeTable : list) {
			System.out.println(employeeTable.toString());
		}
		model.addAttribute("list", list);
		return "employee-list";
	}

	@RequestMapping("delete_emp/{employee_id}")
	public String deleteUser(@PathVariable int employee_id, Model model) {
		System.out.println(employee_id);
		if (employeeDao.delete(employee_id)) {
			model.addAttribute("message", "deleted");
		}
		return "employee-list";
	}

	@RequestMapping("add_emp1")
	public String redirectadd(Model model) {
		model.addAttribute("employeetable", new EmployeeTable());
		
		return "employee-add";
	}
	
	@RequestMapping("add_emp") 
	public String addUser(@ModelAttribute("employeetable") EmployeeTable employeeTable, Model model) {
		employeeDao.save(employeeTable);
		return listEmployee(model);
	}
	
	
	
	
	
	
	@RequestMapping("edit_employee/{employee_id}")
	public String getSingleUser(@ModelAttribute("employee_id") int employee_id, Model model) {
		System.out.println("inside getSingleUser");
		EmployeeTable employee = employeeDao.get(employee_id);
		model.addAttribute("employee", employee);
		System.out.println(employee);
		//model.addAttribute("employeetable", new EmployeeTable());
		return "employee-edit";
	}
	
	@PostMapping("edit_employee1")
	public String employeeUpdate(@ModelAttribute("employee") EmployeeTable employeeTable, Model model) {
		System.out.println("entered");
		employeeDao.update(employeeTable);
		return listEmployee(model);
	}
	

	
	
	
	
	
	@RequestMapping("search-employee1")
	public String displaySearch(Model model) {
		model.addAttribute("employeeTable", new EmployeeTable());
		return "employee-search";
	}
	@PostMapping("search_employee")
	public String employeeSearch(@ModelAttribute("employeeTable") EmployeeTable employeeTable, Model model) {
		int employee_id = employeeTable.getEmployee_id();
		EmployeeTable employee = employeeDao.get(employee_id);
		model.addAttribute("employee", employee);
		System.out.println(employee);
		return "display-search";
	}
	
	
	
	
	
	//LOGIN

	
	@Autowired
	private LoginDao loginDao;
	
	
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
			return listEmployee(model);
		}
		if (resultString.equals("false")) {
			return "homepage.jsp?status=false";
		}
		return Login(model);
	}
}
