package com.group9.gametime.services;

import com.group9.gametime.beans.schedule.Schedule;

import java.io.IOException;
import java.time.LocalDate;

public interface ScheduleService {
    Schedule getScheduleByDateAndCompetitionId(LocalDate date, int competitionId) throws IOException;
}
