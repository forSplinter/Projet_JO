package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.AthleteDto;

import java.util.List;

public interface AthleteServices {
    List<AthleteDto> getAllAthletes();
    AthleteDto getAthleteById(Integer id);
    AthleteDto createAthlete(AthleteDto athleteDto);
    AthleteDto updateAthlete(Integer id, AthleteDto athleteDto);
    void deleteAthlete(Integer id);
}
