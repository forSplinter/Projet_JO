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
@Table(name = "medals")
public class MedalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medalId;
    @ManyToOne
    private DisciplineEntity discipline;

    private String country;
    private Integer gold;
    private Integer silver;
    private Integer bronze;

}
