package com.group9.gametime.servlets;

import com.group9.gametime.repositories.api.LiveScoreScheduleRepository;
import com.group9.gametime.beans.Game;
import com.group9.gametime.beans.Schedule;
import com.group9.gametime.repositories.api.enums.ApiSetting;
import com.group9.gametime.services.ScheduleService;
import com.group9.gametime.services.api.LiveScoreScheduleService;
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
    private final int ENGLISH_LEAGUE_COMPETITION_ID = 2;

    private List<Game> games;
    private ScheduleService scheduleService;

    @Override
    public void init() throws ServletException {
        games = new ArrayList<>();
        scheduleService = new LiveScoreScheduleService(new LiveScoreScheduleRepository());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Hardcoding March 19th, 2022 (date when there are games scheduled). Otherwise, nothing to display.
        LocalDate date = LocalDate.of(2022, 5, 15);

        Schedule schedule = scheduleService.getScheduleByDateAndCompetitionId(date, ENGLISH_LEAGUE_COMPETITION_ID);
        games = schedule.getData().getGames();
        String allGames = generateGamesTable(games, date);
        String page = HtmlStringBuilder.buildString(request.getServletContext().getRealPath("/index.html"), allGames);
        response.getWriter().write(page);
    }

    private String generateGamesTable(List<Game> games, LocalDate date) {
        String page = "";

        if(!games.isEmpty()) {
            page = "<table style='text-align:center; margin-left:auto; margin-right:auto'>\n\n";

            page += "<tr>" +
                    "<th colspan='5'>" + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) + "</th>"+
                    "</tr>";

            page += "<tr>" +
                    "<th colspan='5'>Round: " + games.get(0).getRound() + "</th>"+
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
