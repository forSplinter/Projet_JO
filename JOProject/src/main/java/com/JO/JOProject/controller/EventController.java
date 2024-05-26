package com.JO.JOProject.controller;

import com.JO.JOProject.domain.dto.EventDto;
import com.JO.JOProject.services.EventServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventServices eventServices;

    public EventController(EventServices eventServices) {
        this.eventServices = eventServices;
    }

    @PostMapping
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto) {
        EventDto createdEvent = eventServices.save(eventDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    @GetMapping
    public ResponseEntity<List<EventDto>> getAllEvents() {
        List<EventDto> events = eventServices.findAll();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Integer id) {
        Optional<EventDto> event = eventServices.findOne(id);
        return event.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable Integer id, @RequestBody EventDto eventDto) {
        EventDto updatedEvent = eventServices.partialUpdate(id, eventDto);
        if (updatedEvent != null) {
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer id) {
        eventServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
