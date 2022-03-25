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
        <jsp:include page="top-nav.jsp"/>
        <h1 class="title">Password Recovery</h1>
        <div class="centre">
            <form action="PasswordRecoveryServlet" method="POST">
                <label>Enter Email:</label><br><input type="email" name = "email"><br><br>
                <input type="submit" value="Recover Password">
            </form>
        </div>
    </body>
</html>