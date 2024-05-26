package com.JO.JOProject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DisciplineDto {
    private Integer disciplineID;
    private String disciplineName;
    private Integer organizerID;
}
