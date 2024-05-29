package com.JO.JOProject.mapper.impl;

import com.JO.JOProject.domain.dto.OrganizerDto;
import com.JO.JOProject.domain.entity.OrganizerEntity;
import com.JO.JOProject.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrganizersMapperImpl implements Mapper<OrganizerEntity, OrganizerDto> {
    private ModelMapper modelMapper;
    public OrganizersMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OrganizerDto mapTo(OrganizerEntity organizerEntity) {
        return modelMapper.map(organizerEntity, OrganizerDto.class);
    }

    @Override
    public OrganizerEntity mapFrom(OrganizerDto organizerDto) {
       return modelMapper.map(organizerDto, OrganizerEntity.class);
    }
}
