package com.JO.JOProject.services.impl;

import com.JO.JOProject.domain.dto.AthleteDto;
import com.JO.JOProject.domain.entity.AthleteEntity;
import com.JO.JOProject.mapper.Mapper;
import com.JO.JOProject.repositories.AthleteRepository;
import com.JO.JOProject.repositories.DisciplineAthleteRepository;
import com.JO.JOProject.repositories.EventRepository;
import com.JO.JOProject.services.AthleteServices;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class AthleteServiceImpl implements AthleteServices {

    private final AthleteRepository athleteRepository;
    private final Mapper<AthleteEntity, AthleteDto> athleteMapper;
    private final EventRepository eventRepository;
    private final DisciplineAthleteRepository disciplineAthleteRepository;

    public AthleteServiceImpl(AthleteRepository athleteRepository,
                              Mapper<AthleteEntity, AthleteDto> athleteMapper,
                              EventRepository eventRepository,
                              DisciplineAthleteRepository disciplineAthleteRepository) {
        this.athleteRepository = athleteRepository;
        this.athleteMapper = athleteMapper;
        this.eventRepository = eventRepository;
        this.disciplineAthleteRepository = disciplineAthleteRepository;
    }

    @Override
    public AthleteDto getAthleteById(Long id) {
        Optional<AthleteEntity> athleteEntityOptional = athleteRepository.findById(id);
        System.out.println( "Bonjour");
        return athleteEntityOptional.map(athleteMapper::mapTo).orElse(null);
    }

    @Override
    public AthleteDto createAthlete(AthleteDto athleteDto) {
        AthleteEntity athleteEntity = athleteMapper.mapFrom(athleteDto);
        athleteEntity = athleteRepository.save(athleteEntity);
        return athleteMapper.mapTo(athleteEntity);
    }

    @Override
    public AthleteDto updateAthlete(Long id, AthleteDto athleteDto) {
        AthleteEntity existingAthlete = athleteRepository.findById(id).orElse(null);
        assert existingAthlete != null;
        AthleteEntity updatedAthlete = athleteRepository.save(existingAthlete);
        return athleteMapper.mapTo(updatedAthlete);
    }

    @Transactional
    public void deleteAthlete(Long id) {
        disciplineAthleteRepository.deleteByAthleteId(id);
        try {
            athleteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Failed to delete athlete with id " + id+"."+ e.getMessage());
        }
    }

    @Override
    public List<AthleteDto> findAll() {
        return StreamSupport.stream(athleteRepository.findAll().spliterator(),false)
                .map(athleteMapper::mapTo)
                .collect(Collectors.toList());
    }

}
