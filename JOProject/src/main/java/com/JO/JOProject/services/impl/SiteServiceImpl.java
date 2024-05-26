package com.JO.JOProject.services.impl;

import com.JO.JOProject.domain.dto.SiteDto;
import com.JO.JOProject.domain.entity.SiteEntity;
import com.JO.JOProject.mapper.Mapper;
import com.JO.JOProject.repositories.SiteRepository;
import com.JO.JOProject.services.SiteServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SiteServiceImpl implements SiteServices {

    private final SiteRepository siteRepository;
    private final Mapper<SiteEntity, SiteDto> siteMapper;

    public SiteServiceImpl(SiteRepository siteRepository, Mapper<SiteEntity, SiteDto> siteMapper) {
        this.siteRepository = siteRepository;
        this.siteMapper = siteMapper;
    }

    @Override
    public SiteDto save(SiteDto siteDto) {
        SiteEntity siteEntity = siteMapper.mapFrom(siteDto);
        siteEntity = siteRepository.save(siteEntity);
        return siteMapper.mapTo(siteEntity);
    }

    @Override
    public List<SiteDto> findAll() {
        return StreamSupport.stream(siteRepository.findAll().spliterator(), false)
                .map(siteMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SiteDto> findOne(Integer id) {
        return siteRepository.findById(id).map(siteMapper::mapTo);
    }

    @Override
    public boolean isExists(Integer id) {
        return siteRepository.existsById(id);
    }

    @Override
    public SiteDto partialUpdate(Integer id, SiteDto siteDto) {
        return siteRepository.findById(id).map(existingSite -> {
            // Update fields
            // For example:
            // Optional.ofNullable(siteDto.getSomeField()).ifPresent(existingSite::setSomeField);
            return siteMapper.mapTo(siteRepository.save(existingSite));
        }).orElse(null); // You can throw an exception if the entity is not found
    }

    @Override
    public void delete(Integer id) {
        siteRepository.deleteById(id);
    }
}