package com.JO.JOProject.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.io.Serializable;

@Data
@Log
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "disciplineatheletes")
public class DisciplineAthleteEntity {
    @EmbeddedId
    private DisciplineAthletedId id;

    @Embeddable
    public static class DisciplineAthletedId implements Serializable {
        private Integer atheleteID;
        private Integer disciplineID;
    }

}
