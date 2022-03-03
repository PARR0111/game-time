<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<! DOCTYPE html>
<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<h1>Login</h1>
		<form action="LoginServlet" method="POST">
			<label>Enter username:</label><input type="text" name = "username"><br>
			<label>Enter password:</label><input type="password" name = "password"><br>
			<input type="submit" value="Login">
		</form>
		<a href="registration.jsp">Register</a>
		<br>
		<a href="passwordrecovery.jsp">Forgot Password?</a>
		<br>
		<br>
		<a href="${pageContext.request.contextPath}/">Back to Schedule</a>
	</body>
</html>