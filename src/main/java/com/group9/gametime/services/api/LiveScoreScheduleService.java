package com.group9.gametime.services.api;

import com.group9.gametime.beans.schedule.Schedule;
import com.group9.gametime.repositories.ScheduleRepository;
import com.group9.gametime.services.ScheduleService;

import java.io.IOException;
import java.time.LocalDate;

public class LiveScoreScheduleService implements ScheduleService {
    private ScheduleRepository scheduleRepository;

    public LiveScoreScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Schedule getScheduleByDateAndCompetitionId(LocalDate date, int competitionId) throws IOException {
        return scheduleRepository.getScheduleByDateAndCompetitionId(date, competitionId);
    }
}
