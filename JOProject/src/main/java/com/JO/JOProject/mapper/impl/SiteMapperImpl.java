package com.JO.JOProject.mapper.impl;

import com.JO.JOProject.domain.dto.SiteDto;
import com.JO.JOProject.domain.entity.SiteEntity;
import com.JO.JOProject.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SiteMapperImpl implements Mapper<SiteEntity, SiteDto> {
    private ModelMapper modelMapper;
    public SiteMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public SiteDto mapTo(SiteEntity siteEntity) {
        return modelMapper.map(siteEntity, SiteDto.class);
    }

    @Override
    public SiteEntity mapFrom(SiteDto siteDto) {
        return modelMapper.map(siteDto, SiteEntity.class);
    }
}
