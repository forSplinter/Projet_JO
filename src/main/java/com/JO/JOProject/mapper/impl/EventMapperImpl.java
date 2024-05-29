package com.JO.JOProject.mapper.impl;

import com.JO.JOProject.domain.dto.EventDto;
import com.JO.JOProject.domain.entity.EventEntity;
import com.JO.JOProject.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EventMapperImpl implements Mapper<EventEntity, EventDto> {
    private ModelMapper modelMapper;

    public EventMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public EventDto mapTo(EventEntity eventEntity) {
        return modelMapper.map(eventEntity, EventDto.class);
    }

    @Override
    public EventEntity mapFrom(EventDto eventDto) {
        return modelMapper.map(eventDto, EventEntity.class);
    }
}








