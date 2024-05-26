package com.JO.JOProject.controller;

import com.JO.JOProject.domain.dto.OrganizerDto;
import com.JO.JOProject.services.OrganizerServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {

    private final OrganizerServices organizerServices;

    public OrganizerController(OrganizerServices organizerServices) {
        this.organizerServices = organizerServices;
    }

    @PostMapping
    public ResponseEntity<OrganizerDto> createOrganizer(@RequestBody OrganizerDto organizerDto) {
        OrganizerDto createdOrganizer = organizerServices.save(organizerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrganizer);
    }

    @GetMapping
    public ResponseEntity<List<OrganizerDto>> getAllOrganizers() {
        List<OrganizerDto> organizers = organizerServices.findAll();
        return ResponseEntity.ok(organizers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizerDto> getOrganizerById(@PathVariable Integer id) {
        Optional<OrganizerDto> organizer = organizerServices.findOne(id);
        return organizer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizerDto> updateOrganizer(@PathVariable Integer id, @RequestBody OrganizerDto organizerDto) {
        OrganizerDto updatedOrganizer = organizerServices.partialUpdate(id, organizerDto);
        if (updatedOrganizer != null) {
            return ResponseEntity.ok(updatedOrganizer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Integer id) {
        organizerServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
