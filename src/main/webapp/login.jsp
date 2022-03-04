<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<! DOCTYPE html>
<html>
	<head>
		<title>Login</title>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css"/>
		
		<style>
		body {
    margin: 0;
    font-family: Arial, Helvetica, sans-serif;
  }
  
  .topnav {
    overflow: hidden;
    background-color: #b30000;
    border: 4px solid black;
  }
  
  .topnav a {
    float: right;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 20px;
  }
  
  .topnav a:hover {
    background-color: #ddd;
    color: black;
  }
  
  .topnav a.active {
    float: left;
    background-color: #b30000;
    color: white;
            
  }

  div.centre {
    margin: auto;
    width: 300px;
    border: 3px solid #d9d9d9;
    border-radius: 12px;
    padding: 14px;
  }

  .title {
      text-align: center;
  }
		
		</style>
		
	</head>
	<body>
	
	<div class="topnav">
		<a class="active" href="${pageContext.request.contextPath}/"><b>GameTime</b></a>
		<a class="active" href="#leagues">Leagues</a>
		<a href="#contact">Contact</a>
		<a href="login.jsp">Login</a>
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