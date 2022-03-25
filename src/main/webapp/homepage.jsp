<%@ page import="com.group9.gametime.beans.schedule.Game" %>
<%@ page import="com.group9.gametime.services.ScheduleService" %>
<%@ page import="com.group9.gametime.services.api.LiveScoreScheduleService" %>
<%@ page import="com.group9.gametime.repositories.api.LiveScoreScheduleRepository" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.group9.gametime.beans.schedule.Schedule" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.format.FormatStyle" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<! DOCTYPE html>
<html>
<head>
	<title>Welcome</title>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css"/>
</head>

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

<body>
<%
	if (session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
%>
<h1 class="title" >Welcome ${username}</h1>
<div class="centre">
<form action="LogoutServlet">
	<input type="submit" value="Logout">
</form>
<form action="PasswordResetServlet">
	<input type="submit" value="Change password">
</form>
<form action="DeleteUserServlet" method="POST">
	<input type="submit" value="Delete account" onclick="return confirm('Are you sure you want to delete your account?');">
</form>
</div>
<br>
    <% int comp = Integer.parseInt( (request.getParameter("comp") != null) ? request.getParameter("comp") : "-1" ); %>
    <% if(comp >= 0) { %>
        <div style="width: 500px" class="centre">
        <%
            ScheduleService scheduleService = new LiveScoreScheduleService(new LiveScoreScheduleRepository());
            LocalDate date = LocalDate.of(2022, 5, 15);

            List<Game> games = new ArrayList();

            {
                try {
                    Schedule schedule = scheduleService.getScheduleByDateAndCompetitionId(date, comp);
                    games = schedule.getData().getGames();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        %>
        <% if(!games.isEmpty()) { %>
            <table style="text-align:center; margin-left:auto; margin-right:auto">
                <tr>
                    <th colspan='5'> <%=date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))%> </th>
                </tr>
                <tr>
                    <th colspan='5'>Round: <%=games.get(0).getRound()%></th>
                </tr>
                <tr>
                    <th> Location </th>
                    <th> Home Team </th>
                    <th> </th>
                    <th> Away Team </th>
                    <th> Local Time </th>
                </tr>
                <% for(Game game : games) { %>
                <tr>
                    <td><%=game.getLocation()%></td>
                    <td><%=game.getHomeTeam()%></td>
                    <td> VS </td>
                    <td><%=game.getAwayTeam()%></td>
                    <td><%=game.getTime()%></td>
                </tr>
                <% } %>
            </table>
        <% } else { %>
            <h3 style="text-align:center; margin-left:auto; margin-right:auto">-- NO GAMES TODAY --</h3>
        <% } %>
        </div>
    <% } else { %>
        <p style="text-align: center">Select a league in the navigation bar to view schedules</p>
    <% } %>
</body>
</html>