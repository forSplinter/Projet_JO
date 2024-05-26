package com.JO.JOProject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AthleteDto {
    private Integer athleteID;
    private String name;
    private String country;
    private Integer age;
    private String gender;
}
