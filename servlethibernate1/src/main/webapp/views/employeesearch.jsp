<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<form action="${pageContext.request.contextPath}/SearchController"
		method="POST">
		<div align="center">
			<h4>SEARCH EMPLOYEE :</h4>
			<p>Enter Employee Id:</p>
			<input type="number" name="employee_id">
			<button type="submit" class="btn btn-secondary">Search</button>
		</div>
	</form>
	<div align="right">
		<a href="${pageContext.request.contextPath}/logout.jsp"><button>Logout</button></a>
	</div>
</body>
</html>