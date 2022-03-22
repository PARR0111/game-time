package com.group9.gametime.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CompetitionData {
    @JsonProperty("competition")
    private List<Competition> competitions;

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }

    @Override
    public String toString() {
        return "CompetitionData{" +
                "competitions=" + competitions +
                '}';
    }
}
