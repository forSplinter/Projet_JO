package com.JO.JOProject.mapper.impl;

import com.JO.JOProject.domain.dto.AthleteDto;
import com.JO.JOProject.domain.entity.DisciplineAthleteEntity;
import com.JO.JOProject.mapper.Mapper;
import org.modelmapper.ModelMapper;

public class AthleteDisciplineMapperImpl implements Mapper<DisciplineAthleteEntity, AthleteDto> {
    private final ModelMapper modelMapper;

    public AthleteDisciplineMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public AthleteDto mapTo(DisciplineAthleteEntity disciplineAthleteEntity) {
        AthleteDto athleteDto = new AthleteDto();
        if (disciplineAthleteEntity.getAthlete() != null) {
            athleteDto = modelMapper.map(disciplineAthleteEntity.getAthlete(), AthleteDto.class);
        }
        return athleteDto;
    }

    @Override
    public DisciplineAthleteEntity mapFrom(AthleteDto athleteDto) {
        return null;
    }
}
