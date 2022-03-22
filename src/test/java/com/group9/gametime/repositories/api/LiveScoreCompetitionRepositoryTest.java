package com.group9.gametime.repositories.api;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class LiveScoreCompetitionRepositoryTest {
    private LiveScoreCompetitionRepository competitionConsumer;

    @Test
    void getCompetitionsByFederation() throws IOException {
        competitionConsumer = new LiveScoreCompetitionRepository();
        competitionConsumer.getCompetitionsByCountry("19");

        System.out.println();
    }
}