package com.group9.gametime.services;

import java.io.IOException;

public interface CompetitionService {
    int getCompetitionsByCountry(int countryId) throws IOException;
}
