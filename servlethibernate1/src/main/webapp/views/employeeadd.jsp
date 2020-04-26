<%@page import="bean.EmployeeTable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
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


	<div class="container">
		<div align="center">
			<h1>EMPLOYEE MANAGEMENT PORTAL</h1>
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
					<div align="left">
						<a class="nav-item nav-link"
							href="${pageContext.request.contextPath}/views/employeeadd.jsp">Add
							Employee </a>
					</div>
					<div align="center">
						<a class="nav-item nav-link"
							href="${pageContext.request.contextPath}/EmployeeController">View
							Employees</a>
					</div>
					<div align="right">
						<a class="nav-item nav-link"
							href="${pageContext.request.contextPath}/views/employeesearch.jsp">Search
							Employee</a>
					</div>
				</div>
			</div>
		</nav>
		<form action="${pageContext.request.contextPath}/AddEmployee"
			method="POST">
			<h4>ADD EMPLOYEE :</h4>
			<table>
				<tr>
					<td>Enter EmployeeID:</td>
					<td><input type="number" name="employee_id" /><br /></td>
				</tr>
				<tr>
					<td>Enter Name:</td>
					<td><input type="text" name="name" /><br /></td>
				</tr>
				<tr>
					<td>Enter Email:</td>
					<td><input type="text" name="email" /><br /></td>
				</tr>
				<tr>
					<td>Enter Password:</td>
					<td><input type="text" name="password" /><br />
				</tr>
				
				<tr>
					<td>Confirm Password:</td>
					<td><input type="text" name="password2" /><br />
				</tr>
				
				<tr>
					<td>Enter Designation:</td>
					<td><input type="text" name="designation" /><br /></td>
				</tr>

				<tr>
					<td>Enter Salary:</td>
					<td><input type="text" name="salary" /><br /></td>
				</tr>

				<tr>
					<td>Enter DOB:</td>
					<td><input type="date" name="dob" /><br /></td>
				</tr>
				<tr>
					<td>Enter Joining Date:</td>
					<td><input type="date" name="joining_date" /><br /></td>
				</tr>
				<tr>
					<td>Enter Mobile:</td>
					<td><input type="text" name="mobile" /><br /></td>
				</tr>
				<tr>
					<td>Enter Manager_id:</td>
					<td><input type="number" name="manager_id" /><br /></td>
				</tr>
				<tr>
					<td>Enter Department Id:</td>
					<td><input type="number" name="dept_id" /><br /></td>
				</tr>
				
			</table>
			<button class="btn btn-secondary" type="submit">Save
				Employee</button>
		</form>
		<div align="right">
			<a href="${pageContext.request.contextPath}/logout.jsp"><button>Logout</button></a>
		</div>
		
	</div>
	<%= request.getAttribute("incorrectpass") %>

</body>
</html>