package com.group9.gametime.services;

import com.group9.gametime.beans.Competition;

import java.io.IOException;
import java.util.List;

public interface CompetitionService {
    List<Competition> getCompetitionsByCountry(String countryId) throws IOException;
}
