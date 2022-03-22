package com.group9.gametime.repositories;

import com.group9.gametime.beans.schedule.Schedule;

import java.io.IOException;
import java.time.LocalDate;

public interface ScheduleRepository {
    Schedule getScheduleByDateAndCompetitionId(LocalDate date, int competitionId) throws IOException;
}
