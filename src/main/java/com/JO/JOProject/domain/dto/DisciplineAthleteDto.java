package com.JO.JOProject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DisciplineAthleteDto {
    private Long id;
    private AthleteDto athlete;
    private DisciplineDto disciplineID;
}
