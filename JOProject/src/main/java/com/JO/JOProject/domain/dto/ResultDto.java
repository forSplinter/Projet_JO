package com.JO.JOProject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResultDto {
    private Integer resultID;
    private Integer eventID;
    private Integer athleteID;
    private String score;
    private String medal;
}
