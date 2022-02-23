package com.group9.gametime.api;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

import static com.group9.gametime.api.ApiSetting.BASE_URL;

public class CompetitionConsumer {
    private static final String FEDERATION_KEY = "federation_id=";

    public void getCompetitionsByFederation(String federationId) throws IOException {
        // Get URL
        URL url = new URL( BASE_URL.getValue() +
                "competitions/list.json&key=X8KGigCRSwWGGnxE&secret=QU14J5EpycOyIebGmWmFcZw4vsLcQjQG?"
                + FEDERATION_KEY
                + federationId);
        // Open connection, set request type to "GET"
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        InputStream responseStream = connection.getInputStream();

        String result = new BufferedReader(new InputStreamReader(responseStream))
                .lines().collect(Collectors.joining("\n"));
        System.out.println(result);

        connection.disconnect();
    }
}
