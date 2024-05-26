package com.JO.JOProject.mapper.impl;

import com.JO.JOProject.domain.dto.ParticipationDto;
import com.JO.JOProject.domain.entity.ParticipationEntity;
import com.JO.JOProject.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ParticipationMapperImpl implements Mapper<ParticipationEntity, ParticipationDto> {
    private ModelMapper modelMapper;
    public ParticipationMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ParticipationDto mapTo(ParticipationEntity participationEntity) {
        return modelMapper.map(participationEntity, ParticipationDto.class);
    }

    @Override
    public ParticipationEntity mapFrom(ParticipationDto participationDto) {
        return modelMapper.map(participationDto, ParticipationEntity.class);
    }
}
