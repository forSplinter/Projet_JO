package com.JO.JOProject.mapper.impl;

import com.JO.JOProject.domain.dto.MedalDto;
import com.JO.JOProject.domain.entity.MedalEntity;
import com.JO.JOProject.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MedalsMapperImpl implements Mapper<MedalEntity, MedalDto> {
    private ModelMapper modelMapper;
    public MedalsMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    
//    @PostConstruct
//    public void configureMapper() {
//    modelMapper.typeMap(MedalEntity.class, MedalDto.class)
//                 .addMappings(mapper -> {
//                     mapper.map(MedalEntity::getDiscipline, MedalDto::setDisciplineID);
//                 });
//    }


    @Override
    public MedalDto mapTo(MedalEntity medalEntity) {
        return modelMapper.map(medalEntity, MedalDto.class);
    }

    @Override
    public MedalEntity mapFrom(MedalDto medalDto) {
        return modelMapper.map(medalDto, MedalEntity.class);
    }
}
