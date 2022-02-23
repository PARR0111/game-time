package com.group9.gametime.api;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

class ScheduleConsumerTest {
    private ScheduleConsumer scheduleConsumer;

    @Test
    void getScheduleByDate() throws IOException {
        scheduleConsumer = new ScheduleConsumer();
        System.out.println(scheduleConsumer.getScheduleByDate(LocalDate.now()));
    }
}