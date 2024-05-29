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
@Table(name = "athletes")
public class AthleteEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "athlete_name", nullable = false)
    private String athleteName;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private Long age;

    @Column(nullable = false)
    private String gender;

}
