<%@page import="bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USERS LIST</title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<body>
	<%
		String email = (String) session.getAttribute("email");

		//redirect user to login page if not logged in
		if (email == null) {
			response.sendRedirect("index.jsp");
		}
	%>

	<div class="container">
		<table border="1" class="table table-striped table-bordered">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Password</th>
				<th>Email</th>
				<th>Sex</th>
				<th>Country</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<c:forEach items="${list1}" var="user">
				<!-- name we copy not the value (list) -->
				<tr>
				
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.password}</td>
					<td>${user.email}</td>
					<td>${user.sex}</td>
					<td>${user.country}</td>
					<td><a
						href="${pageContext.request.contextPath}/UserController?action=EDIT&id=${user.id}">Edit</a>
					</td>
					<td><a
						href="${pageContext.request.contextPath}/UserController?action=DELETE&id=${user.id}">Delete</a>
					</td>
				</tr>

			</c:forEach>
		</table>

		<a href="${pageContext.request.contextPath}/views/users-add.jsp">Add
			User</a>
		<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
	</div>
</body>
</html>