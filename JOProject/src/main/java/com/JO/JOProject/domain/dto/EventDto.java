package com.JO.JOProject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@Builder
public class EventDto {
    private Integer eventID;
    private Integer disciplineID;
    private LocalDate date;
    private LocalTime time;
    private Integer siteID;
    private Integer organizerID;
}
