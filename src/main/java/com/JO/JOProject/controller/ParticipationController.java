package com.JO.JOProject.controller;

import com.JO.JOProject.domain.dto.ParticipationDto;
import com.JO.JOProject.services.ParticipationServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/participations")
public class ParticipationController {

    private final ParticipationServices participationServices;

    public ParticipationController(ParticipationServices participationServices) {
        this.participationServices = participationServices;
    }

    @PostMapping
    public ResponseEntity<ParticipationDto> createParticipation(@RequestBody ParticipationDto participationDto) {
        ParticipationDto createdParticipation = participationServices.save(participationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParticipation);
    }

    @GetMapping
    public ResponseEntity<List<ParticipationDto>> getAllParticipations() {
        List<ParticipationDto> participations = participationServices.findAll();
        return ResponseEntity.ok(participations);
    }

    @GetMapping("/{athleteId}/{eventId}")
    public ResponseEntity<ParticipationDto> getParticipationById(@PathVariable Long athleteId, @PathVariable Long eventId) {
        Optional<ParticipationDto> participation = participationServices.findOne(athleteId, eventId);
        return participation.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{athleteId}/{eventId}")
    public ResponseEntity<ParticipationDto> updateParticipation(@PathVariable Long athleteID, @PathVariable Long eventID, @RequestBody ParticipationDto participationDto) {
        ParticipationDto updatedParticipation = participationServices.partialUpdate(athleteID, eventID, participationDto);
        if (updatedParticipation != null) {
            return ResponseEntity.ok(updatedParticipation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{athleteId}/{eventId}")
    public ResponseEntity<Void> deleteParticipation(@PathVariable Long athleteID, @PathVariable Long eventID) {
        participationServices.delete(athleteID, eventID);
        return ResponseEntity.noContent().build();
    }
}
