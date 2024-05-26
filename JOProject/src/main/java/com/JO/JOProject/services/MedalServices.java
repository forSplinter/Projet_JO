package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.MedalDto;

import java.util.List;
import java.util.Optional;

public interface MedalServices {
    MedalDto save(MedalDto medalDto);
    List<MedalDto> findAll();
    Optional<MedalDto> findOne(Integer id);
    boolean isExists(Integer id);
    MedalDto partialUpdate(Integer id, MedalDto medalDto);
    void delete(Integer id);
}
