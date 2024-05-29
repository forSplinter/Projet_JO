package com.JO.JOProject.services.impl;

import com.JO.JOProject.domain.dto.ResultDto;
import com.JO.JOProject.domain.entity.ResultEntity;
import com.JO.JOProject.mapper.Mapper;
import com.JO.JOProject.repositories.ResultRepository;
import com.JO.JOProject.services.ResultServices;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ResultServiceImpl implements ResultServices {

    private final ResultRepository resultRepository;
    private final Mapper<ResultEntity, ResultDto> resultMapper;

    public ResultServiceImpl(ResultRepository resultRepository, @Lazy Mapper<ResultEntity, ResultDto> resultMapper) {
        this.resultRepository = resultRepository;
        this.resultMapper = resultMapper;
    }

    @Override
    public ResultDto save(ResultDto resultDto) {
        ResultEntity resultEntity = resultMapper.mapFrom(resultDto);
        resultEntity = resultRepository.save(resultEntity);
        return resultMapper.mapTo(resultEntity);
    }

    @Override
    public List<ResultDto> findAll() {
        return StreamSupport.stream(resultRepository.findAll().spliterator(), false)
                .map(resultMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ResultDto> findOne(Long id) {
        return resultRepository.findById(id).map(resultMapper::mapTo);
    }

    @Override
    public boolean isExists(Long id) {
        return resultRepository.existsById(id);
    }

    @Override
    public ResultDto partialUpdate(Long id, ResultDto resultDto) {
        return resultRepository.findById(id).map(existingResult -> {
            // Update fields
            // For example:
            // Optional.ofNullable(resultDto.getSomeField()).ifPresent(existingResult::setSomeField);
            return resultMapper.mapTo(resultRepository.save(existingResult));
        }).orElse(null); // You can throw an exception if the entity is not found
    }

    @Override
    public void delete(Long id) {
        resultRepository.deleteById(id);
    }

    @Override
    public List<ResultDto> findByEventId(Long eventID) {
        return List.of();
    }

    @Override
    public List<ResultDto> findByAthleteId(Long athleteID) {
        return List.of();
    }
}