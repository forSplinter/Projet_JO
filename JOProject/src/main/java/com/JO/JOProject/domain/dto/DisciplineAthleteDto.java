package com.JO.JOProject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DisciplineAthleteDto {
    private Integer athleteID;
    private Integer disciplineID;
}
