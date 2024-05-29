package com.JO.JOProject.mapper.impl;

import com.JO.JOProject.domain.dto.ResultDto;
import com.JO.JOProject.domain.dto.SiteDto;
import com.JO.JOProject.domain.entity.ResultEntity;
import com.JO.JOProject.domain.entity.SiteEntity;
import com.JO.JOProject.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ResultMapperImpl implements Mapper<ResultEntity, ResultDto> {
    private ModelMapper modelMapper;
    public ResultMapperImpl(ModelMapper modelMapper) {
        this.modelMapper =  modelMapper;
    }

    @Override
    public ResultDto mapTo(ResultEntity resultEntity) {
        return modelMapper.map(resultEntity,ResultDto.class);
    }

    @Override
    public ResultEntity mapFrom(ResultDto resultDto) {
        return modelMapper.map(resultDto, ResultEntity.class);
    }
}


