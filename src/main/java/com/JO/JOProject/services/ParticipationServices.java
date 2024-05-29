package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.ParticipationDto;

import java.util.List;
import java.util.Optional;

public interface ParticipationServices {
    ParticipationDto save(ParticipationDto participationDto);
    List<ParticipationDto> findAll();
    Optional<ParticipationDto> findOne(Long athleteId, Long eventId);
    boolean isExists(Long athleteId, Long eventId);
    ParticipationDto partialUpdate(Long athleteId, Long eventId, ParticipationDto participationDto);
    void delete(Long athleteId, Long eventId);
}
