package com.group9.gametime.api;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionConsumerTest {
    private CompetitionConsumer competitionConsumer;

    @Test
    void getCompetitionsByFederation() throws IOException {
        competitionConsumer = new CompetitionConsumer();
        competitionConsumer.getCompetitionsByFederation("2");
    }
}