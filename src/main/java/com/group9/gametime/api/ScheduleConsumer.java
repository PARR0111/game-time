package com.group9.gametime.api;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import static com.group9.gametime.api.ApiSetting.BASE_URL;

public class ScheduleConsumer {
    public void getScheduleForADate(LocalDate date) throws IOException {
        // Get URL
        URL url = new URL( BASE_URL.getValue() +
                "fixtures/matches.json?competition_id=244&key=X8KGigCRSwWGGnxE&secret=QU14J5EpycOyIebGmWmFcZw4vsLcQjQG&date="
                + date.toString());

        String jsonPayload = HttpRequestHelper.sendGetRequest(url);
        System.out.println(jsonPayload);
    }
}
