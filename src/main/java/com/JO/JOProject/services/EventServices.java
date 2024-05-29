package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.AthleteDto;
import com.JO.JOProject.domain.dto.EventDto;

import java.util.List;
import java.util.Optional;

public interface EventServices {
    EventDto save(EventDto eventDto);
    List<EventDto> findAll();
    Optional<EventDto> findOne(Long id);
    boolean isExists(Long id);
    EventDto partialUpdate(Long id, EventDto eventDto);
    void delete(Long id);
    List<AthleteDto> findAthletesByEventId(Long id);

    void addAthleteToEVent(Long id, Long id1);
}
