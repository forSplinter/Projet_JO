package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.MedalDto;

import java.util.List;
import java.util.Optional;

public interface MedalServices {
    MedalDto save(MedalDto medalDto);
    List<MedalDto> findAll();
    Optional<MedalDto> findOne(Long id);
    boolean isExists(Long id);
    MedalDto partialUpdate(Long id, MedalDto medalDto);
    void delete(Long id);

    List<MedalDto> findByDisciplineId(Long disciplineID);
}
