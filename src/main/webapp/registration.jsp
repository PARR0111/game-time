<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>New User Registration</h1>
	<form action="RegisterServlet" method="POST">
	Username: <input type="text" name = "username"><br>
	Password: <input type="password" name = "password"><br>
	Re-enter password: <input type="password" name = "password_conf"><br>
	Email: <input type="email" name = "email"><br>
	<input type="submit" value="Register">
	</form>
	
</body>
</html>