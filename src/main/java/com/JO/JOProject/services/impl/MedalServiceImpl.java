package com.JO.JOProject.services.impl;

import com.JO.JOProject.domain.dto.MedalDto;
import com.JO.JOProject.domain.entity.MedalEntity;
import com.JO.JOProject.mapper.Mapper;
import com.JO.JOProject.repositories.MedalRepository;
import com.JO.JOProject.services.MedalServices;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MedalServiceImpl implements MedalServices {

    private final MedalRepository medalRepository;
    private final Mapper<MedalEntity, MedalDto> medalMapper;
    private final ModelMapper modelMapper;

    public MedalServiceImpl(MedalRepository medalRepository, Mapper<MedalEntity, MedalDto> medalMapper, ModelMapper modelMapper) {
        this.medalRepository = medalRepository;
        this.medalMapper = medalMapper;
        this.modelMapper = modelMapper;
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
    public Optional<MedalDto> findOne(Long id) {
        return medalRepository.findById(id).map(medalMapper::mapTo);
    }

    @Override
    public boolean isExists(Long id) {
        return medalRepository.existsById(id);
    }

    @Override
    public MedalDto partialUpdate(Long id, MedalDto medalDto) {
        return medalRepository.findById(id).map(existingMedal -> {
            // Update fields
            // For example:
            // Optional.ofNullable(medalDto.getSomeField()).ifPresent(existingMedal::setSomeField);
            return medalMapper.mapTo(medalRepository.save(existingMedal));
        }).orElse(null); // You can throw an exception if the entity is not found
    }

    @Override
    public void delete(Long id) {
        medalRepository.deleteById(id);
    }

    @Override
    public List<MedalDto> findByDisciplineId(Long disciplineID) {
        List<MedalEntity> medals = medalRepository.findByDisciplineId(disciplineID);
                return medals.stream()
                        .map(medal -> modelMapper.map(medal, MedalDto.class))
                        .collect(Collectors.toList());
    }
}