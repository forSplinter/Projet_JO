package com.JO.JOProject.services.impl;

import com.JO.JOProject.domain.dto.EventDto;
import com.JO.JOProject.domain.entity.EventEntity;
import com.JO.JOProject.mapper.Mapper;
import com.JO.JOProject.repositories.EventRepository;
import com.JO.JOProject.services.EventServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class EventServiceImpl implements EventServices {

    private final EventRepository eventRepository;
    private final Mapper<EventEntity, EventDto> eventMapper;

    public EventServiceImpl(EventRepository eventRepository, Mapper<EventEntity, EventDto> eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public EventDto save(EventDto eventDto) {
        EventEntity eventEntity = eventMapper.mapFrom(eventDto);
        eventEntity = eventRepository.save(eventEntity);
        return eventMapper.mapTo(eventEntity);
    }

    @Override
    public List<EventDto> findAll() {
        return StreamSupport.stream(eventRepository.findAll().spliterator(), false)
                .map(eventMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EventDto> findOne(Integer id) {
        return eventRepository.findById(id).map(eventMapper::mapTo);
    }

    @Override
    public boolean isExists(Integer id) {
        return eventRepository.existsById(id);
    }

    @Override
    public EventDto partialUpdate(Integer id, EventDto eventDto) {
        return eventRepository.findById(id).map(existingEvent -> {
            // Update fields
            // For example:
            // Optional.ofNullable(eventDto.getSomeField()).ifPresent(existingEvent::setSomeField);
            return eventMapper.mapTo(eventRepository.save(existingEvent));
        }).orElse(null); // You can throw an exception if the entity is not found
    }

    @Override
    public void delete(Integer id) {
        eventRepository.deleteById(id);
    }
}