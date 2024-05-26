package com.JO.JOProject.mapper.impl;

import com.JO.JOProject.domain.dto.DisciplineAthleteDto;
import com.JO.JOProject.domain.entity.DisciplineAthleteEntity;
import com.JO.JOProject.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DisciplineAtheleteMapperImpl implements Mapper<DisciplineAthleteEntity, DisciplineAthleteDto> {
    private ModelMapper modelMapper;
    public DisciplineAtheleteMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
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
