<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Verification</title>
</head>
<body>
		<%
		if (session.getAttribute("id")==null) 
		{
			response.sendRedirect("login.jsp");
		}
	%>
	<h1>Your id is ${id}</h1>
	
	<form action="account_verification" method="POST">
	<input type="submit" value="Verify account">
	</form>
</body>
</html>