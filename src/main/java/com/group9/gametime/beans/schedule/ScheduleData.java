package com.group9.gametime.beans.schedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(value = {"prev_page", "next_page"})
public class ScheduleData {
    @JsonProperty("fixtures")
    private List<Game> games;

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "Data{" +
                "games=" + games +
                '}';
    }
}
