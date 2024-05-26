package com.JO.JOProject.controller;

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

    @PostMapping
    public ResponseEntity<DisciplineDto> createDiscipline(@RequestBody DisciplineDto disciplineDto) {
        DisciplineDto createdDiscipline = disciplineServices.save(disciplineDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDiscipline);
    }

    @GetMapping
    public ResponseEntity<List<DisciplineDto>> getAllDisciplines() {
        List<DisciplineDto> disciplines = disciplineServices.findAll();
        return ResponseEntity.ok(disciplines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplineDto> getDisciplineById(@PathVariable Integer id) {
        Optional<DisciplineDto> discipline = disciplineServices.findOne(id);
        return discipline.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplineDto> updateDiscipline(@PathVariable Integer id, @RequestBody DisciplineDto disciplineDto) {
        DisciplineDto updatedDiscipline = disciplineServices.partialUpdate(id, disciplineDto);
        if (updatedDiscipline != null) {
            return ResponseEntity.ok(updatedDiscipline);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscipline(@PathVariable Integer id) {
        disciplineServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}