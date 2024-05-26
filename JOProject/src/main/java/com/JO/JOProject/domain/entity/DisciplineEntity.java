package com.JO.JOProject.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Data
@Log
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "discipline")
public class DisciplineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer disciplineID;
    private String disciplineName;
    @ManyToOne
    private OrganizerEntity organizer;
}
