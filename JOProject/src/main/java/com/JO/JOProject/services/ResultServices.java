package com.JO.JOProject.services;

import com.JO.JOProject.domain.dto.ResultDto;

import java.util.List;
import java.util.Optional;

public interface ResultServices {
    ResultDto save(ResultDto resultDto);
    List<ResultDto> findAll();
    Optional<ResultDto> findOne(Integer id);
    boolean isExists(Integer id);
    ResultDto partialUpdate(Integer id, ResultDto resultDto);
    void delete(Integer id);
}
