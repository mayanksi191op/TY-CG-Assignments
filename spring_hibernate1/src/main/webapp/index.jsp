<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<%-- <%
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
		<form:form action="login" modelAttribute="employeetable">
			<div class="card">
				<h4>LOGIN :</h4>
				<table>
					<tr>
						<td>Enter Employee Id:</td>
						<td><form:input type="number" path="employee_id" modelAttribute="employeetable"/></td>
					</tr>
					<tr>
						<td>Enter password:</td>
						<td><form:input path="password" modelAttribute="employeetable"/></td>
					</tr>
					
				</table>
			</div>
			<input type ="submit" value = "login" class = "btn btn-primary" />
		</form:form>
	</div>
	</div> 
	 --%>
	
	
	
	<!-- <h1>WELCOME</h1>
	<a href="employee">homepage</a>
	 -->
	 
	<h1>WELCOME</h1>
	<a href="login">login</a>
	
</body>
</html>