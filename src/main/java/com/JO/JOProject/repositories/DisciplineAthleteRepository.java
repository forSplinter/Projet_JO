package com.JO.JOProject.repositories;

import com.JO.JOProject.domain.entity.DisciplineAthleteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DisciplineAthleteRepository extends CrudRepository<DisciplineAthleteEntity, Long> {
    Optional<DisciplineAthleteEntity> findByAthleteIdAndDisciplineId(Long athleteId, Long disciplineId);
    List<DisciplineAthleteEntity> findByAthleteId (Long athleteID);
    List<DisciplineAthleteEntity> findByDisciplineId(Long disciplineID);
    boolean existsByAthleteIdAndDisciplineId(Long athleteID, Long disciplineID);

    void deleteByAthleteIdAndDisciplineId(Long athleteID, Long disciplineID);
    void deleteByAthleteId(Long athleteID);
}
