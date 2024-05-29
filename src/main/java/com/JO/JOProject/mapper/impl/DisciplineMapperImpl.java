package com.JO.JOProject.mapper.impl;

import com.JO.JOProject.domain.dto.DisciplineDto;
import com.JO.JOProject.domain.entity.DisciplineEntity;
import com.JO.JOProject.mapper.Mapper;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
public class DisciplineMapperImpl implements Mapper<DisciplineEntity, DisciplineDto> {
    private ModelMapper modelMapper;

    @Override
    public DisciplineDto mapTo(DisciplineEntity disciplineEntity) {
        return modelMapper.map(disciplineEntity, DisciplineDto.class);
    }

    @Override
    public DisciplineEntity mapFrom(DisciplineDto disciplineDto) {
        return modelMapper.map(disciplineDto, DisciplineEntity.class);
    }
}
