package com.group9.gametime.repositories.api;

import com.group9.gametime.repositories.CompetitionRepository;
import com.group9.gametime.repositories.api.helpers.HttpRequestHelper;

import java.io.*;
import java.net.URL;

import static com.group9.gametime.repositories.api.enums.ApiSetting.*;

public class LiveScoreCompetitionRepository implements CompetitionRepository {
    private static final String COUNTRY_KEY = "country_id=";

    public int getCompetitionsByCountry(int countryId) throws IOException {
        // Get URL
        URL url = new URL( BASE_URL.getValue() +
                "competitions/list.json&" + "&"+ KEY.getValue() + "&" + SECRET.getValue() + "?"
                + COUNTRY_KEY
                + countryId);

        String jsonPayload = HttpRequestHelper.sendGetRequest(url);
        System.out.println(jsonPayload);
        return 0;
    }
}
