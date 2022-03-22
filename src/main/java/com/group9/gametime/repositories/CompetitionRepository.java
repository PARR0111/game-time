package com.group9.gametime.repositories;

import com.group9.gametime.beans.competition.Competition;

import java.io.IOException;
import java.util.List;

public interface CompetitionRepository {
    List<Competition> getCompetitionsByCountry(String countryId) throws IOException;
}
