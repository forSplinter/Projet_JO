package com.JO.JOProject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedalDto {
    private Long id;
    private DisciplineDto discipline;
    private String country;
    private Long gold;
    private Long silver;
    private Long bronze;
}
