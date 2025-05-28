package com.techlead.model.sakila;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "store")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id", columnDefinition = "TINYINT UNSIGNED")
    private Short storeId;

    @ManyToOne
    @JoinColumn(name = "manager_staff_id", nullable = false, unique = true, columnDefinition = "TINYINT UNSIGNED")
    private Staff manager;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
    private Address address;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}

