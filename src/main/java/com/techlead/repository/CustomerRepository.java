package com.techlead.repository;

import com.techlead.dto.request.query2.Query29;
import com.techlead.model.sakila.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT DISTINCT c.first_name, c.last_name " +
            "FROM customer c " +
            "JOIN rental r ON c.customer_id = r.customer_id " +
            "JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "JOIN film f ON i.film_id = f.film_id " +
            "JOIN film_category fc ON f.film_id = fc.film_id " +
            "JOIN category cat ON fc.category_id = cat.category_id " +
            "WHERE NOT EXISTS ( " +
            "    SELECT 1 " +
            "    FROM rental r2 " +
            "    JOIN inventory i2 ON r2.inventory_id = i2.inventory_id " +
            "    JOIN film f2 ON i2.film_id = f2.film_id " +
            "    JOIN film_category fc2 ON f2.film_id = fc2.film_id " +
            "    WHERE r2.customer_id = c.customer_id " +
            "      AND fc2.category_id = cat.category_id " +
            "      AND r2.rental_date < r.rental_date " +
            ")", nativeQuery = true)
    List<Query29> query29();
}
