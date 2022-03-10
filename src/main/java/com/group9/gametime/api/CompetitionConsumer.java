package com.group9.gametime.api;

import com.group9.gametime.api.helpers.HttpRequestHelper;

import java.io.*;
import java.net.URL;

import static com.group9.gametime.api.ApiSetting.BASE_URL;

public class CompetitionConsumer {
    private static final String FEDERATION_KEY = "federation_id=";

    public void getCompetitionsByFederation(String federationId) throws IOException {
        // Get URL
        URL url = new URL( BASE_URL.getValue() +
                "competitions/list.json&key=NUS2mBNqkmup6Fbr&secret=OaSpX6XRI64PJoXxjPAFrn5LKAbQfni3?"
                + FEDERATION_KEY
                + federationId);

        String jsonPayload = HttpRequestHelper.sendGetRequest(url);
        System.out.println(jsonPayload);
    }
}
