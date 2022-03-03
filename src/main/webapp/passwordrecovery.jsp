<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Recovery</title>
</head>
<body>
<h1>Password Recovery</h1>
	<form action="PasswordRecoveryServlet" method="POST">
	Enter email: <input type="email" name = "email"><br>
	<input type="submit" value="Recover password">
	</form>
</body>
</html>