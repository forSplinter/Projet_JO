package com.JO.JOProject.services.impl;

import com.JO.JOProject.domain.dto.DisciplineDto;
import com.JO.JOProject.domain.entity.DisciplineEntity;
import com.JO.JOProject.mapper.Mapper;
import com.JO.JOProject.repositories.DisciplineRepository;
import com.JO.JOProject.services.DisciplineServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.JO.JOProject.domain.dto.DisciplineDto;
import com.JO.JOProject.domain.entity.DisciplineEntity;
import com.JO.JOProject.mapper.Mapper;
import com.JO.JOProject.repositories.DisciplineRepository;
import com.JO.JOProject.services.DisciplineServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DisciplineServiceImpl implements DisciplineServices {

    private final DisciplineRepository disciplineRepository;
    private final Mapper<DisciplineEntity, DisciplineDto> disciplineMapper;

    public DisciplineServiceImpl(DisciplineRepository disciplineRepository, Mapper<DisciplineEntity, DisciplineDto> disciplineMapper) {
        this.disciplineRepository = disciplineRepository;
        this.disciplineMapper = disciplineMapper;
    }

    @Override
    public DisciplineDto save(DisciplineDto disciplineDto) {
        DisciplineEntity disciplineEntity = disciplineMapper.mapFrom(disciplineDto);
        disciplineEntity = disciplineRepository.save(disciplineEntity);
        return disciplineMapper.mapTo(disciplineEntity);
    }

    @Override
    public List<DisciplineDto> findAll() {
        return StreamSupport.stream(disciplineRepository.findAll().spliterator(), false)
                .map(disciplineMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DisciplineDto> findOne(Integer id) {
        return disciplineRepository.findById(Math.toIntExact(id)).map(disciplineMapper::mapTo);
    }

    @Override
    public boolean isExists(Integer id) {
        return disciplineRepository.existsById(Math.toIntExact(id));
    }

    @Override
    public DisciplineDto partialUpdate(Integer id, DisciplineDto disciplineDto) {
        return disciplineRepository.findById(Math.toIntExact(id)).map(existingDiscipline -> {
            // Update fields
            // For example:
            // Optional.ofNullable(disciplineDto.getSomeField()).ifPresent(existingDiscipline::setSomeField);
            return disciplineMapper.mapTo(disciplineRepository.save(existingDiscipline));
        }).orElse(null); // You can throw an exception if the entity is not found
    }

    @Override
    public void delete(Integer id) {
        disciplineRepository.deleteById(Math.toIntExact(id));
    }
}


