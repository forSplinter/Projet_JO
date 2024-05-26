package com.JO.JOProject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OrganizerDto {
    private Integer organizerID;
    private String name;
    private String email;
    private String password;
    private String role;
}
