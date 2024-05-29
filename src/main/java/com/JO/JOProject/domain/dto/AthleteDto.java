package com.JO.JOProject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AthleteDto {
    private Long id;
    private String athleteName;
    private String country;
    private Long age;
    private String gender;
}
