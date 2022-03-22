package com.group9.gametime.repositories.api;

import com.group9.gametime.beans.CompetitionResponse;
import com.group9.gametime.beans.Competition;
import com.group9.gametime.repositories.CompetitionRepository;
import com.group9.gametime.repositories.api.helpers.HttpRequestHelper;
import com.group9.gametime.repositories.api.helpers.JsonParser;

import java.io.*;
import java.net.URL;
import java.util.List;

import static com.group9.gametime.repositories.api.enums.ApiSetting.*;

public class LiveScoreCompetitionRepository implements CompetitionRepository {
    private static final String COUNTRY_KEY = "country_id=";

    public List<Competition> getCompetitionsByCountry(String countryId) throws IOException {
        // Get URL
        URL url = new URL( BASE_URL.getValue() +
                "competitions/list.json&" + KEY.getValue() + "&" + SECRET.getValue() + "?"
                + COUNTRY_KEY
                + countryId);

        String jsonPayload = HttpRequestHelper.sendGetRequest(url);

        JsonParser<CompetitionResponse> jsonParser = new JsonParser(CompetitionResponse.class);
        return jsonParser.parse(jsonPayload).getData().getCompetitions();
    }
}
