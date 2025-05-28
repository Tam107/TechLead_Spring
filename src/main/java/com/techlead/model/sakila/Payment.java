package com.techlead.model.sakila;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", columnDefinition = "SMALLINT UNSIGNED")
    private Integer paymentId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, columnDefinition = "SMALLINT UNSIGNED")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false, columnDefinition = "TINYINT UNSIGNED")
    private Staff staff;

    @Column(name = "rental_id")
    private Integer rentalId;

    @Column(name = "amount", precision = 5, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}