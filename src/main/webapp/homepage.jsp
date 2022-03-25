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
    <body>
        <jsp:include page="top-nav.jsp"/>
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