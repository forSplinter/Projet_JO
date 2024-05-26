package com.JO.JOProject.services.impl;

import com.JO.JOProject.domain.dto.OrganizerDto;
import com.JO.JOProject.domain.entity.OrganizerEntity;
import com.JO.JOProject.mapper.Mapper;
import com.JO.JOProject.repositories.OrganizerRepository;
import com.JO.JOProject.services.OrganizerServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrganizerServiceImpl implements OrganizerServices {

    private final OrganizerRepository organizerRepository;
    private final Mapper<OrganizerEntity, OrganizerDto> organizerMapper;

    public OrganizerServiceImpl(OrganizerRepository organizerRepository, Mapper<OrganizerEntity, OrganizerDto> organizerMapper) {
        this.organizerRepository = organizerRepository;
        this.organizerMapper = organizerMapper;
    }

    @Override
    public OrganizerDto save(OrganizerDto organizerDto) {
        OrganizerEntity organizerEntity = organizerMapper.mapFrom(organizerDto);
        organizerEntity = organizerRepository.save(organizerEntity);
        return organizerMapper.mapTo(organizerEntity);
    }

    @Override
    public List<OrganizerDto> findAll() {
        return StreamSupport.stream(organizerRepository.findAll().spliterator(), false)
                .map(organizerMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OrganizerDto> findOne(Integer id) {
        return organizerRepository.findById(id).map(organizerMapper::mapTo);
    }

    @Override
    public boolean isExists(Integer id) {
        return organizerRepository.existsById(id);
    }

    @Override
    public OrganizerDto partialUpdate(Integer id, OrganizerDto organizerDto) {
        return organizerRepository.findById(id).map(existingOrganizer -> {
            // Update fields
            // For example:
            // Optional.ofNullable(organizerDto.getSomeField()).ifPresent(existingOrganizer::setSomeField);
            return organizerMapper.mapTo(organizerRepository.save(existingOrganizer));
        }).orElse(null); // You can throw an exception if the entity is not found
    }

    @Override
    public void delete(Integer id) {
        organizerRepository.deleteById(id);
    }
}