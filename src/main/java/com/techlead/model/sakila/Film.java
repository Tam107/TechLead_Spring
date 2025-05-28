package com.techlead.model.sakila;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "film")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", columnDefinition = "SMALLINT UNSIGNED")
    private Integer filmId;

    @Column(name = "title", length = 128, nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "release_year")
    private Short releaseYear;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false, columnDefinition = "TINYINT UNSIGNED")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "original_language_id", columnDefinition = "TINYINT UNSIGNED")
    private Language originalLanguage;

    @Column(name = "rental_duration", nullable = false)
    private Short rentalDuration;

    @Column(name = "rental_rate", precision = 4, scale = 2, nullable = false)
    private BigDecimal rentalRate;

    @Column(name = "length")
    private Integer length;

    @Column(name = "replacement_cost", precision = 5, scale = 2, nullable = false)
    private BigDecimal replacementCost;

    @Column(name = "rating", length = 5)
    private String rating;

    @Column(name = "special_features")
    private String specialFeatures;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "film")
    private Set<FilmActor> filmActors;

    @OneToMany(mappedBy = "film")
    private Set<FilmCategory> filmCategories;
}