package com.JO.JOProject.controller;

import com.JO.JOProject.domain.dto.DisciplineAthleteDto;
import com.JO.JOProject.services.DisciplineAthleteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disciplineAthletes")
public class DisciplineAthleteController {

    private final DisciplineAthleteService disciplineAthleteService;

    public DisciplineAthleteController(DisciplineAthleteService disciplineAthleteService) {
        this.disciplineAthleteService = disciplineAthleteService;
    }

    @PostMapping
    public ResponseEntity<DisciplineAthleteDto> createDisciplineAthlete(@RequestBody DisciplineAthleteDto disciplineAthleteDto) {
        DisciplineAthleteDto createdDisciplineAthlete = disciplineAthleteService.save(disciplineAthleteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDisciplineAthlete);
    }

    @GetMapping
    public ResponseEntity<List<DisciplineAthleteDto>> getAllDisciplineAthletes() {
        List<DisciplineAthleteDto> disciplineAthletes = disciplineAthleteService.findAll();
        return ResponseEntity.ok(disciplineAthletes);
    }

    @GetMapping("/{athleteId}/{disciplineId}")
    public ResponseEntity<DisciplineAthleteDto> getDisciplineAthlete(@PathVariable Integer athleteId, @PathVariable Integer disciplineId) {
        Optional<DisciplineAthleteDto> disciplineAthlete = disciplineAthleteService.findOne(athleteId, disciplineId);
        return disciplineAthlete.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{athleteId}/{disciplineId}")
    public ResponseEntity<DisciplineAthleteDto> updateDisciplineAthlete(@PathVariable Integer athleteId, @PathVariable Integer disciplineId, @RequestBody DisciplineAthleteDto disciplineAthleteDto) {
        DisciplineAthleteDto updatedDisciplineAthlete = disciplineAthleteService.partialUpdate(athleteId, disciplineId, disciplineAthleteDto);
        if (updatedDisciplineAthlete != null) {
            return ResponseEntity.ok(updatedDisciplineAthlete);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{athleteId}/{disciplineId}")
    public ResponseEntity<Void> deleteDisciplineAthlete(@PathVariable Integer athleteId, @PathVariable Integer disciplineId) {
        disciplineAthleteService.delete(athleteId, disciplineId);
        return ResponseEntity.noContent().build();
    }
}
