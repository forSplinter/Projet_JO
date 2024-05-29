package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.AthleteDto;
import com.JO.JOProject.domain.dto.DisciplineDto;

import java.util.List;
import java.util.Optional;

public interface DisciplineServices {
    DisciplineDto save(DisciplineDto disciplineDto);
    List<DisciplineDto> findAll();
    Optional<DisciplineDto> findOne(Long id);
    boolean isExists(Long id);
    DisciplineDto partialUpdate(Long id, DisciplineDto disciplineDto);
    void delete(Long id);

    void addAthleteToDiscipline(Long athleteID, Long disciplineID);

    List<AthleteDto> findAthletesByDisciplineId(Long id);
}
