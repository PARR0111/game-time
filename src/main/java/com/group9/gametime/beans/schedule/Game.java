package com.group9.gametime.beans.schedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;

@JsonIgnoreProperties(value =
        {"league_id", "competition_id", "odds", "away_translations",
                "home_id", "home_translations", "id", "competition", "h2h", "league", "away_id"})
public class Game {
    private String location;
    private LocalDate date;
    @JsonProperty("home_name")
    private String homeTeam;
    @JsonProperty("away_name")
    private String awayTeam;
    private String round;
    private LocalTime time;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Game{" +
                "location='" + location + '\'' +
                ", date=" + date +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", round='" + round + '\'' +
                ", time=" + time +
                '}';
    }
}
