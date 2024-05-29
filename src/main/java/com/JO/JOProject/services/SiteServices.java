package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.SiteDto;

import java.util.List;
import java.util.Optional;

public interface SiteServices {
    SiteDto save(SiteDto siteDto);
    List<SiteDto> findAll();
    Optional<SiteDto> findOne(Long id);
    boolean isExists(Long id);
    SiteDto partialUpdate(Long id, SiteDto siteDto);
    void delete(Long id);
}
