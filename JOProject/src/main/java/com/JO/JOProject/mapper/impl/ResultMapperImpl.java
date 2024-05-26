package com.JO.JOProject.mapper.impl;

import com.JO.JOProject.domain.dto.ResultDto;
import com.JO.JOProject.domain.entity.ResultEntity;
import com.JO.JOProject.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ResultMapperImpl implements Mapper<ResultEntity, ResultDto> {
    private Mapper<ResultEntity, ResultDto> mapper;
    public ResultMapperImpl(Mapper<ResultEntity, ResultDto> mapper) {
        this.mapper = mapper;
    }

    @Override
    public ResultDto mapTo(ResultEntity resultEntity) {
        return mapper.mapTo(resultEntity);
    }

    @Override
    public ResultEntity mapFrom(ResultDto resultDto) {
        return mapper.mapFrom(resultDto);
    }
}
