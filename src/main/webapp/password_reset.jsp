<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<! DOCTYPE html>
<html>
<head>
	<title>Login</title>
		<script type="text/javascript">
		console.log("script running");
		function Validate(){ 

		var password = document.getElementById('password').value;
		var password_conf = document.getElementById('password_conf').value;
		
		const button = document.getElementById('submit_btn');

		
		if ( password != password_conf ) {
			alert("Passwords do not match");
			return false;
		}
		return true;
		}
	
	</script>
	<meta charset="ISO-8859-1">
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



<h1 class="title" >Password Reset</h1>
<div class="centre">
	<form action="PasswordResetServlet" method="POST">
		<label>Password:</label><br><input type="password" id="password" name = "password"><br><br>
		<label>Re-enter password:</label><br><input type="password" id="password_conf" name = "password_conf"><br><br>
		<input type="submit" value="Submit" onclick="return Validate()">
	</form>
</div>
<br>
<br>

</body>
</html>