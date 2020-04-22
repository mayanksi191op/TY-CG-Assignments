<%@page import="com.tyss.cg.spring_hibernate1.controller.EmployeeController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		
	<div class="container">
	<div align="center">
		<h1>EMPLOYEE MANAGEMENT PORTAL</h1>
	</div>
	<form:form action="edit_employee1" modelAttribute="employee">
		<table>
			<tr>
				<td>Enter employee_id:</td>
				<td><form:input type="number" path="employee_id" modelAttribute="employee" value="${employee.employee_id}"/></td>
			</tr>
			<tr>
				<td>Enter email:</td>
				<td><form:input path="email" modelAttribute="employee" value="${employee.email}"/></td>
			</tr>
			<tr>
				<td>Enter Name:</td>
				<td><form:input path="name" modelAttribute="employee" value="${employee.name}"/></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><form:input path="password" modelAttribute="employee" value="${employee.password}"/></td>
			</tr>
			<tr>
				<td>Enter Designation:</td>
				<td><form:input path="designation" modelAttribute="employee" value="${employee.designation}"/></td>
			</tr>
			<tr>
				<td>Enter Mobile:</td>
				<td><form:input path="mobile" modelAttribute="employee" value="${employee.mobile}"/></td>
			</tr>
			<tr>
				<td>Enter salary:</td>
				<td><form:input path="salary" modelAttribute="employee" value="${employee.salary}"/></td>
			</tr>
			<tr>
				<td>Enter Dept_id:</td>
				<td><form:input type="number" path="dept_id" modelAttribute="employee" value="${employee.dept_id}"/></td>
			</tr>
			<tr>
				<td>Enter Manager_id:</td>
				<td><form:input type="number" path="manager_id" modelAttribute="employee" value="${employee.manager_id}"/></td>
			</tr>
			<tr>
				<td>Enter joining date:</td>
				<td><form:input type="date" path="joining_date" modelAttribute="employee" value="${employee.joining_date}"/></td>
			</tr>
			<tr>
				<td>Enter dob:</td>
				<td><form:input type="date" path="dob" modelAttribute="employee" value="${employee.dob}"/></td>
			</tr>
			
		</table>
		<%-- <form:hidden path="employee_id" modelAttribute="employeetable"/> --%>
		<button type="submit" class="btn btn-secondary">Submit</button>
	</form:form>
	</div>	
		
</body>
</html>