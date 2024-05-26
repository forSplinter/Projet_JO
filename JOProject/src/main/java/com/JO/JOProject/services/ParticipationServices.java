package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.ParticipationDto;

import java.util.List;
import java.util.Optional;

public interface ParticipationServices {
    ParticipationDto save(ParticipationDto participationDto);
    List<ParticipationDto> findAll();
    Optional<ParticipationDto> findOne(Integer athleteId, Integer eventId);
    boolean isExists(Integer athleteId, Integer eventId);
    ParticipationDto partialUpdate(Integer athleteId, Integer eventId, ParticipationDto participationDto);
    void delete(Integer athleteId, Integer eventId);
}
