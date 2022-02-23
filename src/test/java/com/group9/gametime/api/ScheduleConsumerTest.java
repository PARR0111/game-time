package com.group9.gametime.api;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleConsumerTest {
    private ScheduleConsumer scheduleConsumer;

    @Test
    void getScheduleForADate() throws IOException {
        scheduleConsumer = new ScheduleConsumer();
        scheduleConsumer.getScheduleForADate(LocalDate.now());
    }
}