package com.techlead.model.sakila;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "film_actor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmActor {
    @EmbeddedId
    private FilmActorId id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id", columnDefinition = "SMALLINT UNSIGNED")
    private Film film;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id", columnDefinition = "SMALLINT UNSIGNED")
    private Actor actor;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
