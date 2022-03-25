<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Account Verification</title>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css"/>
</head>
<body>
    <jsp:include page="top-nav.jsp"/>
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