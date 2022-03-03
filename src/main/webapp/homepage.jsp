<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<! DOCTYPE html>
<html>
<head>
<title>Welcome</title>
</head>
	
	<body>
	<%
		if (session.getAttribute("username")==null) 
		{
			response.sendRedirect("login.jsp");
		}
	%>
	<h1>Welcome ${username}</h1>
	
	<form action="LogoutServlet">
		<input type="submit" value="logout">
	</form>
	</body>
</html>