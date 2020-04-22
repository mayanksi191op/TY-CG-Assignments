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
	<form:form action="add_emp" modelAttribute="employeetable">
	
		<table>
			<tr>
				<td>Enter Employee Id:</td>
				<td><form:input type="number" path="employee_id" modelAttribute="employeetable"/></td>
			</tr>
			<tr>
				<td>Enter email:</td>
				<td><form:input path="email" modelAttribute="employeetable"/></td>
			</tr>
			<tr>
				<td>Enter Name:</td>
				<td><form:input path="name" modelAttribute="employeetable"/></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><form:input path="password" modelAttribute="employeetable"/></td>
			</tr>
			<tr>
				<td>Enter Designation:</td>
				<td><form:input path="designation" modelAttribute="employeetable"/></td>
			</tr>
			<tr>
				<td>Enter Mobile:</td>
				<td><form:input path="mobile" modelAttribute="employeetable"/></td>
			</tr>
			<tr>
				<td>Enter salary:</td>
				<td><form:input path="salary" modelAttribute="employeetable"/></td>
			</tr>
			<tr>
				<td>Enter Dept_id:</td>
				<td><form:input type="number" path="dept_id" modelAttribute="employeetable"/></td>
			</tr>
			<tr>
				<td>Enter Manager_id:</td>
				<td><form:input type="number" path="manager_id" modelAttribute="employeetable"/></td>
			</tr>
			<tr>
				<td>Enter joining date:</td>
				<td><form:input type="date" path="joining_date" modelAttribute="employeetable"/></td>
			</tr>
			<tr>
				<td>Enter dob:</td>
				<td><form:input type="date" path="dob" modelAttribute="employeetable"/></td>
			</tr>
		
		</table>
		<input type="submit" value="submit" />
	</form:form>
	</div>	
		
</body>
</html>