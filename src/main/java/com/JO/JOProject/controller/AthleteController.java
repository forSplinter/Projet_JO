package com.JO.JOProject.controller;

import com.JO.JOProject.domain.dto.AthleteDto;
import com.JO.JOProject.services.AthleteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/athletes")
public class AthleteController {

    private final AthleteServices athleteService;

    @Autowired
    public AthleteController(AthleteServices athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping
    public ResponseEntity<List<AthleteDto>> getAllAthletes() {
        List<AthleteDto>athletes = athleteService.findAll();
        return ResponseEntity.ok(athletes);
    }

    @GetMapping( "/{id}")
    public ResponseEntity<AthleteDto> getAthleteById(@PathVariable("id") Long id) {
        AthleteDto athleteDto = athleteService.getAthleteById(id);
        return ResponseEntity.ok().body(athleteDto);
    }

    @PostMapping
    public ResponseEntity<AthleteDto> createAthlete(@RequestBody AthleteDto athleteDto) {
        AthleteDto createdAthlete = athleteService.createAthlete(athleteDto);
        return ResponseEntity.ok().body(createdAthlete);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AthleteDto> updateAthlete(@PathVariable Long id, @RequestBody AthleteDto athleteDto) {
        AthleteDto updatedAthlete = athleteService.updateAthlete(id, athleteDto);
        return ResponseEntity.ok().body(updatedAthlete);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> deleteAthlete(@PathVariable Long id) {
        try{
            athleteService.deleteAthlete(id);
            return ResponseEntity.ok().build();
        }catch (DataIntegrityViolationException e){
        return ResponseEntity.status(409).body(e.getMessage());
        }
    }
}
