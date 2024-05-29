package com.JO.JOProject.controller;

import com.JO.JOProject.domain.dto.AthleteDto;
import com.JO.JOProject.domain.dto.DisciplineDto;
import com.JO.JOProject.services.DisciplineServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {

    private final DisciplineServices disciplineServices;

    public DisciplineController(DisciplineServices disciplineServices) {
        this.disciplineServices = disciplineServices;
    }

    @GetMapping
    public ResponseEntity<List<DisciplineDto>> getAllDisciplines() {
        List<DisciplineDto> disciplines = disciplineServices.findAll();
        return ResponseEntity.ok(disciplines);
    }

    @PostMapping
    public ResponseEntity<DisciplineDto> createDiscipline(@RequestBody DisciplineDto disciplineDto) {
        DisciplineDto createdDiscipline = disciplineServices.save(disciplineDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDiscipline);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplineDto> getDisciplineById(@PathVariable Long id) {
        Optional<DisciplineDto> discipline = disciplineServices.findOne(id);
        return discipline.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplineDto> updateDiscipline(@PathVariable Long id, @RequestBody DisciplineDto disciplineDto) {
        DisciplineDto updatedDiscipline = disciplineServices.partialUpdate(id, disciplineDto);
        if (updatedDiscipline != null) {
            return ResponseEntity.ok(updatedDiscipline);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscipline(@PathVariable Long id) {
        disciplineServices.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/athletes")
    public ResponseEntity<List<AthleteDto>> getAthletesByDiscipline(@PathVariable Long id) {
        List<AthleteDto> athletes = disciplineServices.findAthletesByDisciplineId(id);
        return ResponseEntity.ok(athletes);
    }
    @PostMapping("/{id}/athletes")
    public ResponseEntity<Void>addAthleteToDiscipline(@PathVariable Long id, @RequestBody AthleteDto athleteDto) {
        disciplineServices.addAthleteToDiscipline(id,athleteDto.getId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}