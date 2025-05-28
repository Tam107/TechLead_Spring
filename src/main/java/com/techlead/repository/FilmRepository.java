package com.techlead.repository;

import com.techlead.dto.request.query1.FilmDTO;
import com.techlead.dto.request.query1.Query14;
import com.techlead.dto.request.query1.Query18;
import com.techlead.dto.request.query2.Query210;
import com.techlead.dto.request.query2.Query23;
import com.techlead.dto.request.query2.Query28;
import com.techlead.dto.request.query3.Query38;
import com.techlead.model.sakila.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    // query 1.2
    @Query("SELECT new com.techlead.dto.request.query1.FilmDTO(f.title, f.rentalRate, f.replacementCost) from Film f")
    List<FilmDTO> findAllFilmDetails();


    // query 1.8
    @Query("select new com.techlead.dto.request.query1.Query18(f.title) "+ "From Film f where f.rating = 'PG-13' and f.length > 120")
    List<Query18> findPg13FilmsLongerThan120Minutes();

    @Query(value = "SELECT DISTINCT f.title AS title, i.inventory_id AS inventoryId " +
            "FROM film f " +
            "JOIN inventory i ON f.film_id = i.film_id " +
            "JOIN rental r ON r.inventory_id = i.inventory_id " +
            "WHERE r.return_date IS NULL", nativeQuery = true)
    List<Query23> findNeverReturnedFilms();


    @Query(value = "SELECT f.title AS title, COUNT(DISTINCT r.customer_id) AS customerCount " +
            "FROM film f " +
            "JOIN inventory i ON f.film_id = i.film_id " +
            "JOIN rental r ON i.inventory_id = r.inventory_id " +
            "GROUP BY f.film_id, f.title " +
            "HAVING COUNT(DISTINCT r.customer_id) > 50 " +
            "AND MAX((SELECT COUNT(*) FROM rental r2 WHERE r2.inventory_id IN " +
            "    (SELECT inventory_id FROM inventory WHERE film_id = f.film_id) " +
            "    AND r2.customer_id = r.customer_id)) = 1", nativeQuery = true)
    List<Query28> findFilmsRentedByManyCustomersOnce();


    @Query(value = "SELECT f.title " +
            "FROM film f " +
            "JOIN inventory i ON f.film_id = i.film_id " +
            "JOIN rental r ON i.inventory_id = r.inventory_id " +
            "JOIN customer c ON r.customer_id = c.customer_id " +
            "WHERE NOT EXISTS ( " +
            "    SELECT 1 " +
            "    FROM customer c2 " +
            "    JOIN rental r2 ON c2.customer_id = r2.customer_id " +
            "    JOIN inventory i2 ON r2.inventory_id = i2.inventory_id " +
            "    JOIN film f2 ON i2.film_id = f2.film_id " +
            "    JOIN film_category fc2 ON f2.film_id = fc2.film_id " +
            "    JOIN category cat2 ON fc2.category_id = cat2.category_id " +
            "    WHERE cat2.name = 'Action' " +
            "      AND c2.customer_id NOT IN ( " +
            "          SELECT r3.customer_id " +
            "          FROM rental r3 " +
            "          JOIN inventory i3 ON r3.inventory_id = i3.inventory_id " +
            "          WHERE i3.film_id = f.film_id " +
            "      ) " +
            ") " +
            "GROUP BY f.film_id, f.title", nativeQuery = true)
    List<Query210> query210();

    @Query(value = "SELECT f.title AS title " +
            "FROM film f " +
            "JOIN inventory i ON f.film_id = i.film_id " +
            "JOIN rental r ON i.inventory_id = r.inventory_id " +
            "WHERE f.film_id NOT IN (" +
            "    SELECT i2.film_id " +
            "    FROM rental r2 " +
            "    JOIN inventory i2 ON r2.inventory_id = i2.inventory_id " +
            "    JOIN rental r3 ON r3.customer_id = r2.customer_id " +
            "    JOIN inventory i3 ON r3.inventory_id = i3.inventory_id " +
            "    JOIN film f3 ON i3.film_id = f3.film_id " +
            "    WHERE f3.rating = 'G'" +
            ") " +
            "GROUP BY f.film_id, f.title " +
            "HAVING COUNT(r.rental_id) > 100", nativeQuery = true)
    List<Query38> Query38();
}
