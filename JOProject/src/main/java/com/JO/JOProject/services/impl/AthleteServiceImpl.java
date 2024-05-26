package com.JO.JOProject.services.impl;

import com.JO.JOProject.domain.dto.AthleteDto;
import com.JO.JOProject.domain.entity.AthleteEntity;
import com.JO.JOProject.mapper.Mapper;
import com.JO.JOProject.repositories.AthleteRepository;
import com.JO.JOProject.services.AthleteServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class AthleteServiceImpl implements AthleteServices {

    private final AthleteRepository athleteRepository;
    private final Mapper<AthleteEntity, AthleteDto> athleteMapper;

    public AthleteServiceImpl(AthleteRepository athleteRepository, Mapper<AthleteEntity, AthleteDto> athleteMapper) {
        this.athleteRepository = athleteRepository;
        this.athleteMapper = athleteMapper;
    }

    @Override
    public List<AthleteDto> getAllAthletes() {
        return StreamSupport.stream(athleteRepository.findAll().spliterator(), false)
                .map(athleteMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public AthleteDto getAthleteById(Integer id) {
        Optional<AthleteEntity> athleteEntityOptional = athleteRepository.findById(Math.toIntExact(id));
        return athleteEntityOptional.map(athleteMapper::mapTo).orElse(null);
    }

    @Override
    public AthleteDto createAthlete(AthleteDto athleteDto) {
        AthleteEntity athleteEntity = athleteMapper.mapFrom(athleteDto);
        athleteEntity = athleteRepository.save(athleteEntity);
        return athleteMapper.mapTo(athleteEntity);
    }

    @Override
    public AthleteDto updateAthlete(Integer id, AthleteDto athleteDto) {
        AthleteEntity existingAthlete = athleteRepository.findById(id).orElse(null);
        if (existingAthlete == null) {
            return null;
        }

        // Mise à jour des champs
        existingAthlete.setName(athleteDto.getName());
        existingAthlete.setCountry(athleteDto.getCountry());
        existingAthlete.setAge(athleteDto.getAge());
        existingAthlete.setGender(athleteDto.getGender());

        AthleteEntity updatedAthlete = athleteRepository.save(existingAthlete);
        return athleteMapper.mapTo(updatedAthlete);
    }

    @Override
    public void deleteAthlete(Integer id) {
        athleteRepository.deleteById(id);
    }
}
