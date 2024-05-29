package com.JO.JOProject.mapper.impl;

import com.JO.JOProject.domain.dto.AthleteDto;
import com.JO.JOProject.domain.entity.AthleteEntity;
import com.JO.JOProject.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AthleteMapperImpl implements Mapper<AthleteEntity, AthleteDto> {
    private ModelMapper modelMapper;
    public AthleteMapperImpl(ModelMapper modelMapper) {this.modelMapper = modelMapper;}

    @Override
    public AthleteDto mapTo(AthleteEntity athleteEntity) {
        return modelMapper.map(athleteEntity, AthleteDto.class);
    }

    @Override
    public AthleteEntity mapFrom(AthleteDto athleteDto) {
        return modelMapper.map(athleteDto, AthleteEntity.class);
    }
}
