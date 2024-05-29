package com.JO.JOProject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ResultDto {
    private Long id;
    private EventDto event;
    private AthleteDto athlete;
    private String score;
    private String medal;
}
