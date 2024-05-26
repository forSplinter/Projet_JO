package com.JO.JOProject.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private Integer eventID;
    @ManyToOne
    private DisciplineEntity discipline;
    private LocalDate date;
    private LocalTime time;
    @ManyToOne
    private SiteEntity site;
    @ManyToOne
    private OrganizerEntity organizers;

}
