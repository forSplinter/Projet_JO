package com.JO.JOProject.repositories;

import com.JO.JOProject.domain.entity.DisciplineAthleteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DisciplineAthleteRepository extends CrudRepository<DisciplineAthleteEntity, DisciplineAthleteEntity.DisciplineAthleteId> {
    Optional<DisciplineAthleteEntity> findByAthleteIdAndDisciplineId(Integer athleteId, Integer disciplineId);

    boolean existsByAthleteIdAndDisciplineId(Integer athleteId, Integer disciplineId);

    void deleteByAthleteIdAndDisciplineId(Integer athleteId, Integer disciplineId);
}
