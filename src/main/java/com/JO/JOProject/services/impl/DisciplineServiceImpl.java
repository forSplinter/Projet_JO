package com.JO.JOProject.services.impl;

import com.JO.JOProject.domain.dto.AthleteDto;
import com.JO.JOProject.domain.dto.DisciplineDto;
import com.JO.JOProject.domain.entity.AthleteEntity;
import com.JO.JOProject.domain.entity.DisciplineAthleteEntity;
import com.JO.JOProject.domain.entity.DisciplineEntity;
import com.JO.JOProject.mapper.Mapper;
import com.JO.JOProject.repositories.AthleteRepository;
import com.JO.JOProject.repositories.DisciplineAthleteRepository;
import com.JO.JOProject.repositories.DisciplineRepository;
import com.JO.JOProject.services.DisciplineServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;



@Service
public class DisciplineServiceImpl implements DisciplineServices {

    private final DisciplineRepository disciplineRepository;
    private final AthleteRepository athleteRepository;
    private final Mapper<DisciplineEntity, DisciplineDto> disciplineMapper;
    private final DisciplineAthleteRepository disciplineAthleteRepository;
    private final Mapper<AthleteEntity, AthleteDto> athleteMapper;



    public DisciplineServiceImpl(DisciplineRepository disciplineRepository, AthleteRepository athleteRepository,
                                 Mapper<DisciplineEntity, DisciplineDto> disciplineMapper, DisciplineAthleteRepository disciplineAthleteRepository, Mapper<AthleteEntity, AthleteDto> athleteMapper) {
        this.disciplineRepository = disciplineRepository;
        this.athleteRepository = athleteRepository;
        this.disciplineMapper = disciplineMapper;
        this.disciplineAthleteRepository = disciplineAthleteRepository;
        this.athleteMapper = athleteMapper;
    }

    @Override
    public DisciplineDto save(DisciplineDto disciplineDto) {
        DisciplineEntity disciplineEntity = disciplineMapper.mapFrom(disciplineDto);
        disciplineEntity = disciplineRepository.save(disciplineEntity);
        return disciplineMapper.mapTo(disciplineEntity);
    }

    @Override
    public List<DisciplineDto> findAll() {
        return StreamSupport.stream(disciplineRepository.findAll().spliterator(), false)
                .map(disciplineMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DisciplineDto> findOne(Long id) {
        return disciplineRepository.findById(id).map(disciplineMapper::mapTo);
    }

    @Override
    public boolean isExists(Long id) {
        return disciplineRepository.existsById(id);
    }

    @Override
    public DisciplineDto partialUpdate(Long id, DisciplineDto disciplineDto) {
        return disciplineRepository.findById(id).map(existingDiscipline -> {
            // Update fields
            // For example:
            // Optional.ofNullable(disciplineDto.getSomeField()).ifPresent(existingDiscipline::setSomeField);
            return disciplineMapper.mapTo(disciplineRepository.save(existingDiscipline));
        }).orElse(null); // You can throw an exception if the entity is not found
    }

    @Override
    public void delete(Long id) {
        disciplineRepository.deleteById(id);
    }

    @Override
    public void addAthleteToDiscipline(Long athleteID, Long disciplineID) {
        AthleteEntity athleteEntity = athleteRepository.findById(athleteID)
                .orElseThrow(() -> new IllegalArgumentException("Athlete with ID " + athleteID + " not found"));
        DisciplineEntity disciplineEntity = disciplineRepository.findById(disciplineID)
                .orElseThrow(() -> new IllegalArgumentException("Discipline not found"+ disciplineID + "not found"));
        DisciplineAthleteEntity disciplineAthleteEntity = new DisciplineAthleteEntity();
        disciplineAthleteEntity.setAthlete(athleteEntity);
        disciplineAthleteEntity.setDiscipline(disciplineEntity);

        disciplineAthleteRepository.save(disciplineAthleteEntity);

    }

    @Override
    public List<AthleteDto> findAthletesByDisciplineId(Long disciplineID) {
        List<DisciplineAthleteEntity> disciplineAthletes = disciplineAthleteRepository.findByDisciplineId(disciplineID);

        return disciplineAthletes.stream()
                .map(disciplineAthlete -> athleteMapper.mapTo(disciplineAthlete.getAthlete()))
                .collect(Collectors.toList());
    }


}


