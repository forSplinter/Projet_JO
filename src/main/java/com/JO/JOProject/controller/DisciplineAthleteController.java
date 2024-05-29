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
        if (disciplineAthleteDto.getAthlete() == null) {
            return ResponseEntity.badRequest().body(null); // Or throw an appropriate exception
        }
        DisciplineAthleteDto savedDto = disciplineAthleteService.save(disciplineAthleteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
    }

    @GetMapping
    public ResponseEntity<List<DisciplineAthleteDto>> getAllDisciplineAthletes() {
        List<DisciplineAthleteDto> disciplineAthletes = disciplineAthleteService.findAll();
        return ResponseEntity.ok(disciplineAthletes);
    }
    @GetMapping("/athletes/{athleteID}")
    public ResponseEntity<List<DisciplineAthleteDto>>getDisciplineAthleteById(@PathVariable Long athleteID) {
        List<DisciplineAthleteDto> disciplines = disciplineAthleteService.findByAthleteId(athleteID);
        return ResponseEntity.ok(disciplines);
    }
    @GetMapping("/disciplines/{disciplineID}")
    public ResponseEntity<List<DisciplineAthleteDto>>getAthletesByDiscipline(@PathVariable Long disciplineID) {
        List<DisciplineAthleteDto>athletes = disciplineAthleteService.findByDisciplineId(disciplineID);
        return ResponseEntity.ok(athletes);
    }
    @GetMapping("/{athleteID}/{disciplineID}")
    public ResponseEntity<DisciplineAthleteDto> getDisciplineAthlete(@PathVariable Long athleteID, @PathVariable Long disciplineID) {
        Optional<DisciplineAthleteDto> disciplineAthlete = disciplineAthleteService.findOne(athleteID, disciplineID);
        return disciplineAthlete.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{athleteID}/{disciplineID}")
    public ResponseEntity<DisciplineAthleteDto> updateDisciplineAthlete(@PathVariable Long athleteID, @PathVariable Long disciplineID, @RequestBody DisciplineAthleteDto disciplineAthleteDto) {
        DisciplineAthleteDto updatedDisciplineAthlete = disciplineAthleteService.partialUpdate(athleteID, disciplineID, disciplineAthleteDto);
        if (updatedDisciplineAthlete != null) {
            return ResponseEntity.ok(updatedDisciplineAthlete);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{athleteId}/{disciplineID}")
    public ResponseEntity<Void> deleteDisciplineAthlete(@PathVariable Long athleteId, @PathVariable Long disciplineID) {
        disciplineAthleteService.delete(athleteId, disciplineID);
        return ResponseEntity.noContent().build();
    }
}
