package com.JO.JOProject.mapper.impl;

import com.JO.JOProject.domain.dto.DisciplineAthleteDto;
import com.JO.JOProject.domain.entity.DisciplineAthleteEntity;
import com.JO.JOProject.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DisciplineAthleteMapperImpl implements Mapper<DisciplineAthleteEntity, DisciplineAthleteDto> {

    private final ModelMapper modelMapper;

    public DisciplineAthleteMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void configureMapper() {
        modelMapper.typeMap(DisciplineAthleteEntity.class, DisciplineAthleteDto.class)
                .addMappings(mapper -> {
                    mapper.map(DisciplineAthleteEntity::getAthlete, DisciplineAthleteDto::setAthlete);
                    mapper.map(DisciplineAthleteEntity::getDiscipline, DisciplineAthleteDto::setDisciplineID);
                });
    }

    @Override
    public DisciplineAthleteDto mapTo(DisciplineAthleteEntity disciplineAthleteEntity) {
        return modelMapper.map(disciplineAthleteEntity, DisciplineAthleteDto.class);
    }

    @Override
    public DisciplineAthleteEntity mapFrom(DisciplineAthleteDto disciplineAthleteDto) {
        return modelMapper.map(disciplineAthleteDto, DisciplineAthleteEntity.class);
    }
}
