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
    <jsp:include page="top-nav.jsp"/>
    <h1>Your account was successfully verified</h1>
    <a href="login.jsp">Return to login</a>
  </body>
</html>