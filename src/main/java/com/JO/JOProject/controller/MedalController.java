package com.JO.JOProject.controller;

import com.JO.JOProject.domain.dto.MedalDto;
import com.JO.JOProject.services.MedalServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medals")
public class MedalController {

    private final MedalServices medalServices;

    public MedalController(MedalServices medalServices) {
        this.medalServices = medalServices;
    }

    @PostMapping
    public ResponseEntity<MedalDto> createMedal(@RequestBody MedalDto medalDto) {
        MedalDto createdMedal = medalServices.save(medalDto);
        return ResponseEntity.ok(createdMedal);
    }

    @GetMapping
    public ResponseEntity<List<MedalDto>> getAllMedals() {
        List<MedalDto> medals = medalServices.findAll();
        return ResponseEntity.ok(medals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedalDto> getMedalById(@PathVariable Long id) {
        Optional<MedalDto> medal = medalServices.findOne(id);
        return medal.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/discipline/{disciplineID}")
    public ResponseEntity<List<MedalDto>> getMedalsByDiscipline(@PathVariable Long disciplineID) {
        List<MedalDto> medals = medalServices.findByDisciplineId(disciplineID);
        return ResponseEntity.ok(medals);
    }


    @PutMapping("/{id}")
    public ResponseEntity<MedalDto> updateMedal(@PathVariable Long id, @RequestBody MedalDto medalDto) {
        MedalDto updatedMedal = medalServices.partialUpdate(id, medalDto);
        if (updatedMedal != null) {
            return ResponseEntity.ok(updatedMedal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedal(@PathVariable Long id) {
        medalServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}