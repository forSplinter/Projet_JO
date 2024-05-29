package com.JO.JOProject.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class DisciplineDto {
    private Long id;
    private String disciplineName;
    private OrganizerDto organizer;
}
