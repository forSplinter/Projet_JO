package com.JO.JOProject.services.impl;

import com.JO.JOProject.domain.dto.ParticipationDto;
import com.JO.JOProject.domain.entity.ParticipationEntity;
import com.JO.JOProject.mapper.Mapper;
import com.JO.JOProject.repositories.ParticipationRepository;
import com.JO.JOProject.services.ParticipationServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ParticipationServiceImpl implements ParticipationServices {

    private final ParticipationRepository participationRepository;
    private final Mapper<ParticipationEntity, ParticipationDto> participationMapper;

    public ParticipationServiceImpl(ParticipationRepository participationRepository, Mapper<ParticipationEntity, ParticipationDto> participationMapper) {
        this.participationRepository = participationRepository;
        this.participationMapper = participationMapper;
    }

    @Override
    public ParticipationDto save(ParticipationDto participationDto) {
        ParticipationEntity participationEntity = participationMapper.mapFrom(participationDto);
        participationEntity = participationRepository.save(participationEntity);
        return participationMapper.mapTo(participationEntity);
    }

    @Override
    public List<ParticipationDto> findAll() {
        return StreamSupport.stream(participationRepository.findAll().spliterator(), false)
                .map(participationMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ParticipationDto> findOne(Integer athleteId, Integer eventId) {
        return participationRepository.findByAthleteIdAndEventId(athleteId, eventId).map(participationMapper::mapTo);
    }

    @Override
    public boolean isExists(Integer athleteId, Integer eventId) {
        return participationRepository.existsByAthleteIdAndEventId(athleteId, eventId);
    }

    @Override
    public ParticipationDto partialUpdate(Integer athleteId, Integer eventId, ParticipationDto participationDto) {
        return participationRepository.findByAthleteIdAndEventId(athleteId, eventId).map(existingParticipation -> {
            // Update fields
            // For example:
            // Optional.ofNullable(participationDto.getSomeField()).ifPresent(existingParticipation::setSomeField);
            return participationMapper.mapTo(participationRepository.save(existingParticipation));
        }).orElse(null); // You can throw an exception if the entity is not found
    }

    @Override
    public void delete(Integer athleteId, Integer eventId) {
        participationRepository.deleteByAthleteIdAndEventId(athleteId, eventId);
    }
}