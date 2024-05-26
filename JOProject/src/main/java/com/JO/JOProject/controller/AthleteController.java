package com.JO.JOProject.controller;

import com.JO.JOProject.domain.dto.AthleteDto;
import com.JO.JOProject.services.AthleteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/athletes")
public class AthleteController {

    private final AthleteServices athleteService;

    @Autowired
    public AthleteController(AthleteServices athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping
    public List<AthleteDto> getAllAthletes() {
        return athleteService.getAllAthletes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AthleteDto> getAthleteById(@PathVariable Integer id) {
        AthleteDto athleteDto = athleteService.getAthleteById(id);
        return ResponseEntity.ok().body(athleteDto);
    }

    @PostMapping
    public ResponseEntity<AthleteDto> createAthlete(@RequestBody AthleteDto athleteDto) {
        AthleteDto createdAthlete = athleteService.createAthlete(athleteDto);
        return ResponseEntity.ok().body(createdAthlete);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AthleteDto> updateAthlete(@PathVariable Integer id, @RequestBody AthleteDto athleteDto) {
        AthleteDto updatedAthlete = athleteService.updateAthlete(id, athleteDto);
        return ResponseEntity.ok().body(updatedAthlete);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAthlete(@PathVariable Integer id) {
        athleteService.deleteAthlete(id);
        return ResponseEntity.ok().build();
    }
}
