package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.AthleteDto;

import java.util.List;

public interface AthleteServices {
    AthleteDto getAthleteById(Long id);
    AthleteDto createAthlete(AthleteDto athleteDto);
    AthleteDto updateAthlete(Long id, AthleteDto athleteDto);
    void deleteAthlete(Long id);
    List<AthleteDto> findAll();
}
