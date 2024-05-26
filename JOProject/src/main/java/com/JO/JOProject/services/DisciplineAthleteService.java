package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.DisciplineAthleteDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DisciplineAthleteService {
    DisciplineAthleteDto save(DisciplineAthleteDto disciplineAthleteDto);
    List<DisciplineAthleteDto> findAll();
    Optional<DisciplineAthleteDto> findOne(Integer athleteId, Integer disciplineId);
    boolean isExists(Integer athleteId, Integer disciplineId);
    DisciplineAthleteDto partialUpdate(Integer athleteId, Integer disciplineId, DisciplineAthleteDto disciplineAthleteDto);
    void delete(Integer athleteId, Integer disciplineId);
}