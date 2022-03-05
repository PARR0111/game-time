package com.group9.gametime.servlets;

import com.group9.gametime.api.ScheduleConsumer;
import com.group9.gametime.beans.Game;
import com.group9.gametime.beans.Schedule;
import com.group9.gametime.servlets.helpers.HtmlStringBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ScheduleServlet", value = "/index")
public class ScheduleServlet extends HttpServlet {
    private List<Game> games;
    private ScheduleConsumer scheduleConsumer;

    @Override
    public void init() throws ServletException {
        games = new ArrayList<>();
        scheduleConsumer = new ScheduleConsumer();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Hardcoding March 15th, 2022 (date when there are games scheduled). Otherwise, nothing to display.
        LocalDate date = LocalDate.of(2022, 3, 15);

        Schedule schedule = scheduleConsumer.getScheduleByDate(date);
        games = schedule.getData().getGames();
        String allGames = generateGamesTable(games, date);
        String page = HtmlStringBuilder.buildString(request.getServletContext().getRealPath("/index.html"), allGames);
        response.getWriter().write(page);
    }

    private String generateGamesTable(List<Game> games, LocalDate date) {
        String page = "";

        if(!games.isEmpty()) {
            page = "<table style='text-align:center'>\n\n";

            page += "<tr>" +
                    "<th colspan='5'>" + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) + "</th>"+
                    "</tr>";

            page += "<tr>" +
                    "<th colspan='5'>" + games.get(0).getRound() + "</th>"+
                    "</tr>";

            page += "<tr>" +
                    "<th> Location </th>" +
                    "<th> Home Team </th>" +
                    "<th> </th>" +
                    "<th> Away Team </th>" +
                    "<th> Local Time </th>" +
                    "</tr>";

            for(Game game : games) {
                page += "<tr>" +
                        "<td>" + game.getLocation() + "</td>" +
                        "<td>" + game.getHomeTeam() + "</td>" +
                        "<td> VS </td>" +
                        "<td>" + game.getAwayTeam() + "</td>" +
                        "<td>" + game.getTime() + "</td>" +
                        "</tr>";
            }

            page += "\n</table>";
        }

        return page;
    }
}
