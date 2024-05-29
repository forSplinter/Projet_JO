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
    @Table(name = "disciplineathletes")
    public class DisciplineAthleteEntity implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "athlete_id", nullable = false)
        private AthleteEntity athlete;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "discipline_id", nullable = false)
        private DisciplineEntity discipline;
    }
