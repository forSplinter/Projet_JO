package com.JO.JOProject.controller;

import com.JO.JOProject.domain.dto.ResultDto;
import com.JO.JOProject.services.ResultServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    private final ResultServices resultServices;

    public ResultController(ResultServices resultService) {
        this.resultServices = resultService;
    }

    @PostMapping
    public ResponseEntity<ResultDto> createResult(@RequestBody ResultDto resultDto) {
        ResultDto createdResult = resultServices.save(resultDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResult);
    }

    @GetMapping
    public ResponseEntity<List<ResultDto>> getAllResults() {
        List<ResultDto> results = resultServices.findAll();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultDto> getResultById(@PathVariable Integer id) {
        Optional<ResultDto> result = resultServices.findOne(id);
        return result.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultDto> updateResult(@PathVariable Integer id, @RequestBody ResultDto resultDto) {
        ResultDto updatedResult = resultServices.partialUpdate(id, resultDto);
        if (updatedResult != null) {
            return ResponseEntity.ok(updatedResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResult(@PathVariable Integer id) {
        resultServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
