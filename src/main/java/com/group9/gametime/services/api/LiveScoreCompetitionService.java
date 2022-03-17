package com.group9.gametime.services.api;

import com.group9.gametime.repositories.CompetitionRepository;
import com.group9.gametime.services.CompetitionService;

import java.io.IOException;

public class LiveScoreCompetitionService implements CompetitionService {
    private CompetitionRepository competitionRepository;

    public LiveScoreCompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public int getCompetitionsByCountry(int countryId)  throws IOException  {
        return competitionRepository.getCompetitionsByCountry(countryId);
    }
}
