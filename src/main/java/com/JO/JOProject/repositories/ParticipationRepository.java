package com.JO.JOProject.repositories;

import com.JO.JOProject.domain.entity.ParticipationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ParticipationRepository extends CrudRepository<ParticipationEntity, Long> {
    Optional<ParticipationEntity> findByAthleteIdAndEventId(Long athleteId, Long eventId);

    boolean existsByAthleteIdAndEventId(Long athleteId, Long eventId);

    void deleteByAthleteIdAndEventId(Long athleteId, Long eventId);
}
