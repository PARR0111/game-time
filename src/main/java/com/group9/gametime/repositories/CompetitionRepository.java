package com.group9.gametime.repositories;

import java.io.IOException;

public interface CompetitionRepository {
    int getCompetitionsByCountry(int countryId) throws IOException;
}
