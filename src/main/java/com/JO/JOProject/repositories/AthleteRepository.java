package com.JO.JOProject.repositories;

import com.JO.JOProject.domain.entity.AthleteEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AthleteRepository extends CrudRepository<AthleteEntity,Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM AthleteEntity a WHERE a.id = :athleteId")
    void deleteByAthleteId(@Param("athleteId") Long athleteId);


}
