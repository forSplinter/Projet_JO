package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.OrganizerDto;

import java.util.List;
import java.util.Optional;

public interface OrganizerServices {
    OrganizerDto save(OrganizerDto organizerDto);
    List<OrganizerDto> findAll();
    Optional<OrganizerDto> findOne(Long id);
    boolean isExists(Long id);
    OrganizerDto partialUpdate(Long id, OrganizerDto organizerDto);
    void delete(Long id);
}
