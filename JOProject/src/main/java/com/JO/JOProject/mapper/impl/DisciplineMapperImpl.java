package com.JO.JOProject.mapper.impl;

import com.JO.JOProject.domain.dto.DisciplineDto;
import com.JO.JOProject.domain.entity.DisciplineEntity;
import com.JO.JOProject.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DisciplineMapperImpl implements Mapper<DisciplineEntity, DisciplineDto> {
    private ModelMapper modelMapper;
    public DisciplineMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public DisciplineDto mapTo(DisciplineEntity disciplineEntity) {
        return modelMapper.map(disciplineEntity, DisciplineDto.class);
    }

    @Override
    public DisciplineEntity mapFrom(DisciplineDto disciplineDto) {
        return modelMapper.map(disciplineDto, DisciplineEntity.class);
    }
}
