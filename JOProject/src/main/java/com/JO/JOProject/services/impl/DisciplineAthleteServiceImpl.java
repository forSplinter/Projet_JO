package com.JO.JOProject.services.impl;

import com.JO.JOProject.domain.dto.DisciplineAthleteDto;
import com.JO.JOProject.domain.entity.DisciplineAthleteEntity;
import com.JO.JOProject.mapper.Mapper;
import com.JO.JOProject.repositories.DisciplineAthleteRepository;
import com.JO.JOProject.services.DisciplineAthleteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DisciplineAthleteServiceImpl implements DisciplineAthleteService {

    private final DisciplineAthleteRepository disciplineAthleteRepository;
    private final Mapper<DisciplineAthleteEntity, DisciplineAthleteDto> disciplineAthleteMapper;

    public DisciplineAthleteServiceImpl(DisciplineAthleteRepository disciplineAthleteRepository, Mapper<DisciplineAthleteEntity, DisciplineAthleteDto> disciplineAthleteMapper) {
        this.disciplineAthleteRepository = disciplineAthleteRepository;
        this.disciplineAthleteMapper = disciplineAthleteMapper;
    }

    @Override
    public DisciplineAthleteDto save(DisciplineAthleteDto disciplineAthleteDto) {
        DisciplineAthleteEntity disciplineAthleteEntity = disciplineAthleteMapper.mapFrom(disciplineAthleteDto);
        disciplineAthleteEntity = disciplineAthleteRepository.save(disciplineAthleteEntity);
        return disciplineAthleteMapper.mapTo(disciplineAthleteEntity);
    }

    @Override
    public List<DisciplineAthleteDto> findAll() {
        return StreamSupport.stream(disciplineAthleteRepository.findAll().spliterator(), false)
                .map(disciplineAthleteMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DisciplineAthleteDto> findOne(Integer athleteId, Integer disciplineId) {
        return disciplineAthleteRepository.findByAthleteIdAndDisciplineId(athleteId, disciplineId).map(disciplineAthleteMapper::mapTo);
    }


    @Override
    public boolean isExists(Integer athleteId, Integer disciplineId) {
        return disciplineAthleteRepository.existsByAthleteIdAndDisciplineId(athleteId, disciplineId);
    }


    @Override
    public DisciplineAthleteDto partialUpdate(Integer athleteId, Integer disciplineId, DisciplineAthleteDto disciplineAthleteDto) {
        return disciplineAthleteRepository.findByAthleteIdAndDisciplineId(athleteId, disciplineId).map(existingDisciplineAthlete -> {
            // Mettre à jour les champs
            // Par exemple :
            // Optional.ofNullable(disciplineAthleteDto.getSomeField()).ifPresent(existingDisciplineAthlete::setSomeField);
            return disciplineAthleteMapper.mapTo(disciplineAthleteRepository.save(existingDisciplineAthlete));
        }).orElse(null); // Vous pouvez lancer une exception si l'entité n'est pas trouvée
    }


    @Override
    public void delete(Integer athleteId, Integer disciplineId) {
        disciplineAthleteRepository.deleteByAthleteIdAndDisciplineId(athleteId, disciplineId);
    }
}