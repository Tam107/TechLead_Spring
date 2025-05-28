package com.techlead.model.sakila;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id", columnDefinition = "MEDIUMINT UNSIGNED")
    private Integer inventoryId;

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false, columnDefinition = "TINYINT UNSIGNED")
    private Store store;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
