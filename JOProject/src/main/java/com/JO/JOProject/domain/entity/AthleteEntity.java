package com.JO.JOProject.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Data
@Log
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "athletesentity")
public class AthleteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer atheleteID;
    private String atheleteName;
    private String country;
    private Integer age;
    private String gender;

    public void setName(String s) {
    }
}
