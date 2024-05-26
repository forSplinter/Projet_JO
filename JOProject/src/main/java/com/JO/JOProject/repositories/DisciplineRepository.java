package com.JO.JOProject.repositories;

import com.JO.JOProject.domain.entity.DisciplineAthleteEntity;
import com.JO.JOProject.domain.entity.DisciplineEntity;
import org.springframework.data.repository.CrudRepository;

public interface DisciplineRepository extends CrudRepository<DisciplineEntity, Integer> {
}
