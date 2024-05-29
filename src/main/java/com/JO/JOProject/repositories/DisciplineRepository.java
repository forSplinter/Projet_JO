package com.JO.JOProject.repositories;

import com.JO.JOProject.domain.entity.AthleteEntity;
import com.JO.JOProject.domain.entity.DisciplineAthleteEntity;
import com.JO.JOProject.domain.entity.DisciplineEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DisciplineRepository extends CrudRepository<DisciplineEntity, Long> {

}

