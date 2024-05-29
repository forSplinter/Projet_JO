package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.DisciplineAthleteDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DisciplineAthleteService {
    DisciplineAthleteDto save(DisciplineAthleteDto disciplineAthleteDto);
    List<DisciplineAthleteDto> findAll();
    Optional<DisciplineAthleteDto> findOne(Long athleteID, Long disciplineID);
    boolean isExists(Long athleteID, Long disciplineID);
    DisciplineAthleteDto partialUpdate(Long athleteID, Long disciplineID, DisciplineAthleteDto disciplineAthleteDto);
    void delete(Long athleteId, Long disciplineId);

    List<DisciplineAthleteDto> findByAthleteId(Long athleteID);

    List<DisciplineAthleteDto> findByDisciplineId(Long disciplineID);
}