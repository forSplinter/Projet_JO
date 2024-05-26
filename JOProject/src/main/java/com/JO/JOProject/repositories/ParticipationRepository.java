package com.JO.JOProject.repositories;

import com.JO.JOProject.domain.entity.ParticipationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ParticipationRepository extends CrudRepository<ParticipationEntity, ParticipationEntity.ParticipationId> {
    Optional<ParticipationEntity> findByAthleteIdAndEventId(Integer athleteId, Integer eventId);

    boolean existsByAthleteIdAndEventId(Integer athleteId, Integer eventId);

    void deleteByAthleteIdAndEventId(Integer athleteId, Integer eventId);
}
