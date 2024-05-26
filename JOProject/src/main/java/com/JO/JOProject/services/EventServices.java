package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.EventDto;

import java.util.List;
import java.util.Optional;

public interface EventServices {
    EventDto save(EventDto eventDto);
    List<EventDto> findAll();
    Optional<EventDto> findOne(Integer id);
    boolean isExists(Integer id);
    EventDto partialUpdate(Integer id, EventDto eventDto);
    void delete(Integer id);
}
