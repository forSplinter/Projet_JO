package com.JO.JOProject.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

@Data
@Log
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private DisciplineEntity discipline;

    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    private SiteEntity site;

    @ManyToOne
    private OrganizerEntity organizers;

    @ManyToMany
    @JoinTable(name = "event_athlete",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    private List<AthleteEntity> athletes;



    // Getter and setters, constructors, etc.
}

