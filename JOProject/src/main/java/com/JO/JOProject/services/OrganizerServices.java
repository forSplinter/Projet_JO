package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.OrganizerDto;

import java.util.List;
import java.util.Optional;

public interface OrganizerServices {
    OrganizerDto save(OrganizerDto organizerDto);
    List<OrganizerDto> findAll();
    Optional<OrganizerDto> findOne(Integer id);
    boolean isExists(Integer id);
    OrganizerDto partialUpdate(Integer id, OrganizerDto organizerDto);
    void delete(Integer id);
}
