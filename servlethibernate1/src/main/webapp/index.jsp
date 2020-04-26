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
	<%
		String employee_id = (String) session.getAttribute("employee_id");
		if (employee_id != null) {
			response.sendRedirect("/views/homepage.jsp");
		}

		String status = request.getParameter("status");

		if (status != null) {
			if (status.equals("false")) {
				out.print("Incorrect");
			} else {
				out.print("error");
			}
		}
	%>

	<div align = "center">
	<h1>EMPLOYEE MANAGEMENT PORTAL: </h1>
	<div class="container">
		<form action="loginprocess" method="post">
			<div class="card">
				<h4>LOGIN :</h4>
				<table>
					<tr>
						<td>Enter Employee Id:</td>
						<td><input type="text" name="employee_id" /></td>
					</tr>
					<tr>
						<td>Enter password:</td>
						<td><input type="text" name="password" /></td>
					</tr>
					
				</table>
			</div>
			<input type ="submit" value = "login" class = "btn btn-primary" />
		</form>
	</div>
	</div>
	
</body>
</html>