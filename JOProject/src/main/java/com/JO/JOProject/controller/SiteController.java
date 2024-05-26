package com.JO.JOProject.controller;

import com.JO.JOProject.domain.dto.SiteDto;
import com.JO.JOProject.services.SiteServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sites")
public class SiteController {

    private final SiteServices siteServices;

    public SiteController(SiteServices siteServices) {
        this.siteServices = siteServices;
    }

    @PostMapping
    public ResponseEntity<SiteDto> createSite(@RequestBody SiteDto siteDto) {
        SiteDto createdSite = siteServices.save(siteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSite);
    }

    @GetMapping
    public ResponseEntity<List<SiteDto>> getAllSites() {
        List<SiteDto> sites = siteServices.findAll();
        return ResponseEntity.ok(sites);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SiteDto> getSiteById(@PathVariable Integer id) {
        Optional<SiteDto> site = siteServices.findOne(id);
        return site.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SiteDto> updateSite(@PathVariable Integer id, @RequestBody SiteDto siteDto) {
        SiteDto updatedSite = siteServices.partialUpdate(id, siteDto);
        if (updatedSite != null) {
            return ResponseEntity.ok(updatedSite);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSite(@PathVariable Integer id) {
        siteServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
