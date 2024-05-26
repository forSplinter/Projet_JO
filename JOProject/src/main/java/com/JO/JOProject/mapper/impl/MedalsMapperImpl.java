package com.JO.JOProject.mapper.impl;

import com.JO.JOProject.domain.dto.MedalDto;
import com.JO.JOProject.domain.entity.MedalEntity;
import com.JO.JOProject.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MedalsMapperImpl implements Mapper<MedalEntity, MedalDto> {
    private ModelMapper modelMapper;
    public MedalsMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MedalDto mapTo(MedalEntity medalEntity) {
        return modelMapper.map(medalEntity, MedalDto.class);
    }

    @Override
    public MedalEntity mapFrom(MedalDto medalDto) {
        return modelMapper.map(medalDto, MedalEntity.class);
    }
}
