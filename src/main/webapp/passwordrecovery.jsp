<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Password Recovery</title>

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
      <a href="homepage.jsp?comp=2">Premier League</a>
      <a href="homepage.jsp?comp=77">Championship</a>
      <a href="homepage.jsp?comp=82">League 1</a>
      <a href="homepage.jsp?comp=83">League 2</a>
      <a href="homepage.jsp?comp=154">National League</a>
      <a href="homepage.jsp?comp=155">National League North / South</a>
      <a href="homepage.jsp?comp=152">FA Cup</a>
      <a href="homepage.jsp?comp=149">Community Shield</a>
      <a href="homepage.jsp?comp=150">EFL Cup</a>
      <a href="homepage.jsp?comp=151">EFL Trophy</a>
      <a href="homepage.jsp?comp=153">FA Trophy</a>
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



<h1 class="title">Password Recovery</h1>
<div class="centre">
	<form action="PasswordRecoveryServlet" method="POST">
		<label>Enter Email:</label><br><input type="email" name = "email"><br><br>
		<input type="submit" value="Recover Password">
	</form>
</div>
</body>
</html>