<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<! DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css"/>

</head>
<body>

<div class="topnav">
    <a class="active" href="${pageContext.request.contextPath}/"><b>GameTime</b></a>
  <% if (session.getAttribute("username")==null){ %>
  <% } else { %>
  <div class="dropdown">
    <button class="dropbtn">Leagues</button>
    <div class="dropdown-content">
      <a href="index2.jsp?comp=2">Premier League</a>
      <a href="index2.jsp?comp=77">Championship</a>
      <a href="index2.jsp?comp=82">League 1</a>
      <a href="index2.jsp?comp=83">League 2</a>
      <a href="index2.jsp?comp=154">National League</a>
      <a href="index2.jsp?comp=155">National League North / South</a>
      <a href="index2.jsp?comp=152">FA Cup</a>
      <a href="index2.jsp?comp=149">Community Shield</a>
      <a href="index2.jsp?comp=150">EFL Cup</a>
      <a href="index2.jsp?comp=151">EFL Trophy</a>
      <a href="index2.jsp?comp=153">FA Trophy</a>
    </div>
  </div> 
  <% } %>
  <div class="rightLink">
	<% if (session.getAttribute("username")==null){ %>
		<a href="login.jsp">Login</a>
	<% } else { %>
		<a href="LogoutServlet">Logout</a>
	<% } %>
	<a href="contact.jsp">Contact</a>
  </div>
</div>



<h1 class="title" >Login</h1>
<div class="centre">
	<form action="LoginServlet" method="POST">
		<label>Username:</label><br><input type="text" name = "username"><br><br>
		<label>Password:</label><br><input type="password" name = "password"><br><br>
		<input type="submit" value="Login">
	</form>
	<a href="registration.jsp">Register</a>
	<br>
	<a href="passwordrecovery.jsp">Forgot Password?</a>
</div>
<br>
<br>

</body>
</html>