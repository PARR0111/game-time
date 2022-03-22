package com.group9.gametime.repositories.api;

import com.group9.gametime.repositories.ScheduleRepository;
import com.group9.gametime.repositories.api.helpers.HttpRequestHelper;
import com.group9.gametime.repositories.api.helpers.JsonParser;
import com.group9.gametime.beans.schedule.Schedule;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import static com.group9.gametime.repositories.api.enums.ApiSetting.*;

public class LiveScoreScheduleRepository implements ScheduleRepository {
    public Schedule getScheduleByDateAndCompetitionId(LocalDate date, int competitionId) throws IOException {
        // Get URL
        URL url = new URL( BASE_URL.getValue() +
                "fixtures/matches.json?competition_id="
                + competitionId
                + "&"+ KEY.getValue() + "&" + SECRET.getValue() + "&date="
                + date.toString());

        String jsonPayload = HttpRequestHelper.sendGetRequest(url);

        JsonParser<Schedule> jsonParser = new JsonParser(Schedule.class);

        return jsonParser.parse(jsonPayload);
    }
}
