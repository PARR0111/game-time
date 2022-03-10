package com.group9.gametime.api;

import com.group9.gametime.api.helpers.HttpRequestHelper;
import com.group9.gametime.api.helpers.JsonParser;
import com.group9.gametime.beans.Schedule;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import static com.group9.gametime.api.ApiSetting.BASE_URL;

public class ScheduleConsumer {
    private static final int COMPETITION_ID = 244;

    public Schedule getScheduleByDate(LocalDate date) throws IOException {
        // Get URL
        URL url = new URL( BASE_URL.getValue() +
                "fixtures/matches.json?competition_id="
                + COMPETITION_ID
                +"&key=NUS2mBNqkmup6Fbr&secret=OaSpX6XRI64PJoXxjPAFrn5LKAbQfni3&date="
                + date.toString());

        String jsonPayload = HttpRequestHelper.sendGetRequest(url);

        JsonParser<Schedule> jsonParser = new JsonParser(Schedule.class);

        return jsonParser.parse(jsonPayload);
    }
}
