<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Verification successful</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css"/>
</head>
<body>
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

<h1>Your account was successfully verified</h1>
<a href="login.jsp">Return to login</a>
</body>
</html>