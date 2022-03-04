<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Verification</title>

<link rel="stylesheet" href="styles.css">

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


		<%
		if (session.getAttribute("id")==null) 
		{
			response.sendRedirect("login.jsp");
		}
	%>
	<h1 class="title">Your id is ${id}</h1>
	<div class="centre">
	<form action="account_verification" method="POST">
	<label>Click here to verify your account.</label><br><br><input type="submit" value="Verify">
	</form>
	</div>
</body>
</html>