<%@page import="bean.UserBean"%>
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
	<div class="container">
		<form action="${pageContext.request.contextPath}/UserController"
			method="POST">
			<table>				
				<tr>
					<td>Enter Name:</td>
					<td><input type="text" name="name" value="${user.name}" /><br /></td>
				</tr>
				<tr>
					<td>Enter Password:</td>
					<td><input type="text" name="password"
						value="${user.password}" /><br />
				</tr>
				<tr>
					<td>Enter Email:</td>
					<td><input type="text" name="email" value="${user.email}" /><br /> </td>
				</tr>
				<tr>
					<td>Enter Sex:</td>
					<td><input type="radio" name="sex" value="male" />male <input
						type="radio" name="sex" value="female">female</td>
				</tr>
				<tr>
					<td>Enter Country:</td>
					<td><select name="country">
							<option value="India">India</option>
							<option value="USA">USA</option>
							<option value="England">England</option>
							
					</select> </td>
				</tr>
			</table>
			<input type="hidden" name="id" value="${user.id}" />
			<button class="btn btn-secondary" type="submit">Save
				Employee</button>
		</form>
	</div>
	<a href="${pageContext.request.contextPath}/UserController?action=LIST">View
		Users</a>
	<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
</body>
</html>