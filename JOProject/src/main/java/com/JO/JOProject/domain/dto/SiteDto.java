package com.JO.JOProject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SiteDto {
    private Integer siteID;
    private String siteName;
    private String address;
    private Integer capacity;
}
