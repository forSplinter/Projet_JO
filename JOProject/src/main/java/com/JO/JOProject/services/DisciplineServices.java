package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.DisciplineDto;

import java.util.List;
import java.util.Optional;

public interface DisciplineServices {
    DisciplineDto save(DisciplineDto disciplineDto);
    List<DisciplineDto> findAll();
    Optional<DisciplineDto> findOne(Integer id);
    boolean isExists(Integer id);
    DisciplineDto partialUpdate(Integer id, DisciplineDto disciplineDto);
    void delete(Integer id);
}
