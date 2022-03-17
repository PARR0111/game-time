package com.group9.gametime.repositories.api;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

class LiveScoreScheduleRepositoryTest {
    private LiveScoreScheduleRepository scheduleConsumer;

    @Test
    void getScheduleByDate() throws IOException {
        scheduleConsumer = new LiveScoreScheduleRepository();
        System.out.println(scheduleConsumer.getScheduleByDateAndCompetitionId(LocalDate.of(2022, 3, 8), 2));
    }
}