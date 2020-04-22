<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@page import="java.util.List"%>
<%@page import="Bean.EmployeeTable"%>
<%@page import="Controller.EmployeeController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div>
		<a href="/servlet_assignment2/views/employeelist.jsp"> See all
			employees </a> <a href="/servlet_assignment2/views/employeeadd.jsp">
			Add employees </a> <a
			href="/servlet_assignment2/views/employeesearch.jsp"> Search
			Employee </a>
	</div>
	<div class="container">
	<form action="${pageContext.request.contextPath}/EmployeeController">
		<table border = "1" class = "table table-striped table-bordered">
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
				<th>Edit</th>
				<th>Delete</th>	
					
				
			</tr> 
			
			
			
			<c:forEach items = "${list}" var = "employee">
				<tr>
					<th>${employee.name}</th>
					<th>${employee.dob}</th>
					<th>${employee.employee_id}</th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				
				</tr>
				
			
			</c:forEach>
		</table>
	</form>
	</div>
</body>
</html>