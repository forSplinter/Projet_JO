package com.JO.JOProject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SiteDto {
    private Long id;
    private String siteName;
    private String SiteAddress;
    private Long siteCapacity;
}
