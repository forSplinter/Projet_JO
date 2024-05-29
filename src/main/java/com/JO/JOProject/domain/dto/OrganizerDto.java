package com.JO.JOProject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OrganizerDto {
    private Long id;
    private String organizerName;
    private String organizerEmail;
    private String organizerPassword;
    private String role;
}
