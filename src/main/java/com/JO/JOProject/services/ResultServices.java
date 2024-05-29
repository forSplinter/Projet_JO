package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.ResultDto;

import java.util.List;
import java.util.Optional;

public interface ResultServices {
    ResultDto save(ResultDto resultDto);
    List<ResultDto> findAll();
    Optional<ResultDto> findOne(Long id);
    boolean isExists(Long id);
    ResultDto partialUpdate(Long id, ResultDto resultDto);
    void delete(Long id);

    List<ResultDto> findByEventId(Long eventID);

    List<ResultDto> findByAthleteId(Long athleteID);
}
