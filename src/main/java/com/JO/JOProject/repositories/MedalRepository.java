package com.JO.JOProject.repositories;

import com.JO.JOProject.domain.entity.MedalEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedalRepository extends CrudRepository<MedalEntity, Long> {
    List<MedalEntity> findByDisciplineId(Long disciplineID);
}
