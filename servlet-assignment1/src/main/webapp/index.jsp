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
		String email = (String) session.getAttribute("email");

		//redirect user to home page if already logged in
		if (email != null) {
			response.sendRedirect("UserController?action=LIST");
		}

		String status = request.getParameter("status");

		if (status != null) {
			if (status.equals("false")) {
				out.print("Incorrect login details!");
			} else {
				out.print("Some error occurred!");
			}
		}
	%>

	<div class="container">
		<form action="loginprocess" method="post">
			<div class="table" >
				<h1>LOGIN PAGE</h1>

				<input type="text" name="email" required class="form-control"
					placeholder="Enter Email" /> <input type="password"
					name="password" required class="form-control"
					placeholder="Enter password" />
			</div>
			<input type="submit" value="Login" class="btn btn-primary" />
		</form>
	

	</div>
	
</body>
</html>