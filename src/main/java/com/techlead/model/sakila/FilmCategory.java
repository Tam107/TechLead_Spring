package com.techlead.model.sakila;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "film_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategory {
    @EmbeddedId
    private FilmCategoryId id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id", columnDefinition = "SMALLINT UNSIGNED")
    private Film film;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id", columnDefinition = "TINYINT UNSIGNED")
    private Category category;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}