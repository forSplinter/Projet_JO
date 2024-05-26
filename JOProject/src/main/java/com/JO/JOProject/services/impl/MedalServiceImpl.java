package com.JO.JOProject.services.impl;

import com.JO.JOProject.domain.dto.MedalDto;
import com.JO.JOProject.domain.entity.MedalEntity;
import com.JO.JOProject.mapper.Mapper;
import com.JO.JOProject.repositories.MedalRepository;
import com.JO.JOProject.services.MedalServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MedalServiceImpl implements MedalServices {

    private final MedalRepository medalRepository;
    private final Mapper<MedalEntity, MedalDto> medalMapper;

    public MedalServiceImpl(MedalRepository medalRepository, Mapper<MedalEntity, MedalDto> medalMapper) {
        this.medalRepository = medalRepository;
        this.medalMapper = medalMapper;
    }

    @Override
    public MedalDto save(MedalDto medalDto) {
        MedalEntity medalEntity = medalMapper.mapFrom(medalDto);
        medalEntity = medalRepository.save(medalEntity);
        return medalMapper.mapTo(medalEntity);
    }

    @Override
    public List<MedalDto> findAll() {
        return StreamSupport.stream(medalRepository.findAll().spliterator(), false)
                .map(medalMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MedalDto> findOne(Integer id) {
        return medalRepository.findById(id).map(medalMapper::mapTo);
    }

    @Override
    public boolean isExists(Integer id) {
        return medalRepository.existsById(id);
    }

    @Override
    public MedalDto partialUpdate(Integer id, MedalDto medalDto) {
        return medalRepository.findById(id).map(existingMedal -> {
            // Update fields
            // For example:
            // Optional.ofNullable(medalDto.getSomeField()).ifPresent(existingMedal::setSomeField);
            return medalMapper.mapTo(medalRepository.save(existingMedal));
        }).orElse(null); // You can throw an exception if the entity is not found
    }

    @Override
    public void delete(Integer id) {
        medalRepository.deleteById(Math.toIntExact(id));
    }
}