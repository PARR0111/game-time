<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<! DOCTYPE html>
<html>
<head>
	<title>Welcome</title>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css"/>
</head>

<div class="topnav">
	<a class="active" href="${pageContext.request.contextPath}/"><b>GameTime</b></a>
	<a class="active" href="#leagues">Leagues</a>
	<a href="#contact">Contact</a>
	
	<% if (session.getAttribute("username")==null){ %>
		<a href="login.jsp">Login</a>
	<% } else { %>
		<a href="LogoutServlet">Logout</a>
	<% } %>
</div>



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