package com.JO.JOProject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MedalDto {
    private Integer medalID;
    private Integer disciplineID;
    private String country;
    private Integer gold;
    private Integer silver;
    private Integer bronze;
}
