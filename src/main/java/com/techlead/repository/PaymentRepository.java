package com.techlead.repository;

import com.techlead.dto.request.query1.Query16;
import com.techlead.model.sakila.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT new com.techlead.dto.request.query1.Query16(s.storeId, SUM(p.amount)) " +
            "FROM Payment p JOIN p.customer c JOIN Rental r ON p.rentalId = r.rentalId " +
            "JOIN r.inventory i JOIN i.store s " +
            "WHERE YEAR(p.paymentDate) = 2021 GROUP BY s.storeId")
    List<Query16> findStoreRevenueFor2021();
}
