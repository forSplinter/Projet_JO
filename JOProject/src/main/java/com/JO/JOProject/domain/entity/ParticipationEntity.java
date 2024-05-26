package com.JO.JOProject.domain.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "participation")
public class ParticipationEntity {
    @EmbeddedId
    private ParticipationId id;

    @Embeddable
    public static class ParticipationId implements Serializable {
        private Integer atheleteID;
        private Integer eventID;
    }
}
