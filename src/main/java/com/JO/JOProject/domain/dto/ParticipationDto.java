package com.JO.JOProject.domain.dto;

import com.JO.JOProject.domain.entity.AthleteEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ParticipationDto {
    private AthleteDto athletes;
    private EventDto event;
}
