<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<body>

	<%
		String email = (String) session.getAttribute("employee_id");

		//redirect user to login page if not logged in
		if (email == null) {
			response.sendRedirect("index.jsp");
		}
	%>



	<div align = "center">
		<h1>EMPLOYEE MANAGEMENT SYSTEM</h1>
	</div>

	<nav
		class="navbar navbar-expand-lg navbar-middle navbar-light bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
					<div align = "left"><a class="nav-item nav-link"
					href="${pageContext.request.contextPath}/views/employeeadd.jsp">Add
					Employee </a> </div>
					<div align="center"><a class="nav-item nav-link"
					href="${pageContext.request.contextPath}/EmployeeController">View
					Employees</a> </div>
					<div align = "right"><a class="nav-item nav-link"
					href="${pageContext.request.contextPath}/views/employeesearch.jsp">Search
					Employee</a></div>
			</div>
		</div>
	</nav>
	
	<div class="container">
		<div align = "center"><h4>EMPLOYEE DETAILS :</h4></div>
		<table border="1" class="table table-striped table-bordered">
			<tr>
				<th>Employee Id</th>
				<th>Name</th>
				<th>DOB</th>
				<th>Joining Date</th>
				<th>Dept Id</th>
				<th>Designation</th>
				<th>Salary</th>
				<th>Manager Id</th>
				<th>Official Email</th>
				<th>Mobile</th>
			</tr>
			
			
				<tr>
					<td>${employee.employee_id}</td>
					<td>${employee.name}</td>
					<td>${employee.dob}</td>
					<td>${employee.joining_date}</td>
					<td>${employee.dept_id}</td>
					<td>${employee.designation}</td>
					<td>${employee.salary}</td>
					<td>${employee.manager_id}</td>
					<td>${employee.email}</td>
					<td>${employee.mobile}</td>
				</tr>

		</table>
	<div align="right">
		<a href="${pageContext.request.contextPath}/logout.jsp"><button>Logout</button></a></div>
	</div>		
	
</body>
</html>