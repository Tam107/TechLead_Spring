package com.techlead.model.sakila;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", columnDefinition = "SMALLINT UNSIGNED")
    private Integer cityId;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
    private Country country;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
