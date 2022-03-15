<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Registration</title>
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
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css"/>
</head>
<body>

<div class="topnav">
	<a class="active" href="${pageContext.request.contextPath}/"><b>GameTime</b></a>
	<a class="active" href="#leagues">Leagues</a>
	<a href="#contact">Contact</a>
	<a href="login.jsp">Login</a>
</div>


<h1 class="title">New User Registration</h1>

<div class="centre">
	<form action="RegisterServlet" method="POST">
		<label>Username:</label><br><input type="text" name = "username"><br><br>
		<label>Password:</label><br><input type="password" id="password" name = "password"><br><br>
		<label>Re-enter password:</label><br><input type="password" id="password_conf" name = "password_conf"><br><br>
		<label>Email:</label><br><input type="email" name = "email"><br><br>
		<input id="submit_btn" type="submit" value="Register" onclick="return Validate()">
	</form>
</div>

</body>
</html>