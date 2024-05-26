package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.SiteDto;

import java.util.List;
import java.util.Optional;

public interface SiteServices {
    SiteDto save(SiteDto siteDto);
    List<SiteDto> findAll();
    Optional<SiteDto> findOne(Integer id);
    boolean isExists(Integer id);
    SiteDto partialUpdate(Integer id, SiteDto siteDto);
    void delete(Integer id);
}
