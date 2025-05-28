package com.techlead.repository;

import com.techlead.dto.request.query1.Query14;
import com.techlead.dto.request.query1.Query15;
import com.techlead.dto.request.query1.RentalStatDTO;
import com.techlead.dto.request.query2.Query210;
import com.techlead.dto.request.query2.Query22;
import com.techlead.dto.request.query2.Query25;
import com.techlead.dto.request.query2.Query29;
import com.techlead.dto.request.query3.*;
import com.techlead.model.sakila.Rental;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    LocalDateTime start = LocalDateTime.of(2022, 1, 1, 0, 0, 0);
    LocalDateTime end = LocalDateTime.of(2022, 1, 31, 23, 59, 59);

    // query 1.3
    @Query("SELECT new com.techlead.dto.request.query1.RentalStatDTO(f.title, COUNT(r)) " +
            "FROM Rental r JOIN r.inventory i JOIN i.film f " +
            "GROUP BY f.filmId, f.title ORDER BY COUNT(r) DESC")
    List<RentalStatDTO> findTop5RentedFilms(Pageable pageable);

    @Query(value = "SELECT c.name AS categoryName, AVG(DATEDIFF(r.return_date, r.rental_date)) AS averageDuration " +
            "FROM rental r " +
            "JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "JOIN film f ON i.film_id = f.film_id " +
            "JOIN film_category fc ON f.film_id = fc.film_id " +
            "JOIN category c ON fc.category_id = c.category_id " +
            "WHERE r.return_date IS NOT NULL " +
            "GROUP BY c.category_id, c.name", nativeQuery = true)
    List<Query14> findAverageRentalDurationByCategory();

    // query 1.5
    @Query("SELECT new com.techlead.dto.request.query1.Query15(c.firstName, c.lastName, a.address, ci.city, co.country) " +
            "FROM Rental r JOIN r.customer c JOIN c.address a JOIN a.city ci JOIN ci.country co " +
            "WHERE r.rentalDate BETWEEN :startDate AND :endDate")
    List<Query15> findCustomersRentingInPeriod(@Param("startDate") LocalDateTime startDate,
                                               @Param("endDate") LocalDateTime endDate);

    // Level 2 Queries
    @Query(value = """
            SELECT c.first_name, c.last_name, c.email
            FROM customer c
            JOIN rental r ON c.customer_id = r.customer_id
            JOIN inventory i ON r.inventory_id = i.inventory_id
            JOIN film f ON i.film_id = f.film_id
            JOIN film_category fc ON f.film_id = fc.film_id
            GROUP BY c.customer_id, c.first_name, c.last_name, c.email
            HAVING COUNT(DISTINCT fc.category_id) = (SELECT COUNT(*) FROM category)
            """, nativeQuery = true)
    List<Query22> findCustomersRentingAllCategories();


    //    select a.first_name, a.last_name from actor a
//join film_actor fa on a.actor_id = fa.actor_id
//join film_category fc on fa.film_id = fc.film_id
//group by a.actor_id, a.first_name, a.last_name
//having count(distinct fc.category_id) = (select count(*) from category);
    @Query(value = "select a.first_name, a.last_name " +
            "from actor a " +
            "join film_actor fa on a.actor_id = fa.actor_id " +
            "join film_category fc on fa.film_id = fc.film_id " +
            "group by a.actor_id, a.first_name, a.last_name " +
            "having count(distinct fc.category_id) = (select count(*) from category)",
            nativeQuery = true)
    List<Query25> findActorsInAllCategories();


    @Query(value = "SELECT DISTINCT r.customer_id " +
            "FROM category c " +
            "JOIN film_category fc ON c.category_id = fc.category_id " +
            "JOIN film f ON fc.film_id = f.film_id " +
            "JOIN inventory i ON f.film_id = i.film_id " +
            "JOIN rental r ON i.inventory_id = r.inventory_id " +
            "WHERE c.name = 'Action'", nativeQuery = true)
    List<Query210> findCustomersRentingActionFilms();

    @Query(value = "SELECT CONCAT(c.first_name, ' ', c.last_name) AS customerName, COUNT(*) AS filmCount, SUM(f.rental_rate) AS totalRentalFee " +
            "FROM customer c " +
            "JOIN rental r ON c.customer_id = r.customer_id " +
            "JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "JOIN film f ON i.film_id = f.film_id " +
            "GROUP BY c.customer_id, c.first_name, c.last_name, DATE(r.rental_date) " +
            "HAVING COUNT(*) > 10 " +
            "ORDER BY customerName, filmCount", nativeQuery = true)
    List<Query33> Query33();

    @Query(value = "SELECT CONCAT(c.first_name, ' ', c.last_name) AS customer_name, " +
            "COUNT(*) AS film_count, " +
            "SUM(f.rental_rate) AS total_rental_fee, " +
            "DATE(r.rental_date) AS rental_date " +
            "FROM customer c " +
            "JOIN rental r ON c.customer_id = r.customer_id " +
            "JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "JOIN film f ON i.film_id = f.film_id " +
            "GROUP BY c.first_name, c.last_name, DATE(r.rental_date) " +
            "HAVING COUNT(*) > 10 " +
            "ORDER BY customer_name, film_count", nativeQuery = true)
    List<Query34> Query34();



    @Query(value = "SELECT f.title AS title, CONCAT(c.first_name, ' ', c.last_name) AS customerName, COUNT(*) AS rentalCount " +
            "FROM rental r " +
            "JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "JOIN film f ON i.film_id = f.film_id " +
            "JOIN customer c ON r.customer_id = c.customer_id " +
            "GROUP BY r.customer_id, f.film_id, DATE(r.rental_date) " +
            "HAVING COUNT(*) > 1 " +
            "ORDER BY title, customerName", nativeQuery = true)
    List<Query35> Query35();

    @Query(value = "SELECT DISTINCT CONCAT(c.first_name, ' ', c.last_name) AS customerName, cat.name AS categoryName, COUNT(*) AS rentalCount " +
            "FROM customer c " +
            "JOIN rental r ON c.customer_id = r.customer_id " +
            "JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "JOIN film f ON i.film_id = f.film_id " +
            "JOIN film_category fc ON f.film_id = fc.film_id " +
            "JOIN category cat ON fc.category_id = cat.category_id " +
            "WHERE NOT EXISTS (" +
            "    SELECT cat2.category_id " +
            "    FROM category cat2 " +
            "    WHERE NOT EXISTS (" +
            "        SELECT 1 " +
            "        FROM rental r2 " +
            "        JOIN inventory i2 ON r2.inventory_id = i2.inventory_id " +
            "        JOIN film f2 ON i2.film_id = f2.film_id " +
            "        JOIN film_category fc2 ON f2.film_id = fc2.film_id " +
            "        WHERE fc2.category_id = cat2.category_id " +
            "        AND r2.customer_id = c.customer_id" +
            "    )" +
            ") " +
            "GROUP BY c.customer_id, c.first_name, c.last_name, cat.category_id, cat.name " +
            "ORDER BY customerName, categoryName", nativeQuery = true)
    List<Query37> Query37();

    @Query(value = "SELECT DISTINCT c.first_name AS firstName, c.last_name AS lastName " +
            "FROM customer c " +
            "JOIN rental r ON c.customer_id = r.customer_id " +
            "JOIN inventory i ON r.inventory_id = i.inventory_id " +
            "JOIN film f ON i.film_id = f.film_id " +
            "JOIN film_category fc ON f.film_id = fc.film_id " +
            "JOIN category cat ON fc.category_id = cat.category_id " +
            "WHERE NOT EXISTS (" +
            "    SELECT 1 " +
            "    FROM rental r2 " +
            "    JOIN inventory i2 ON r2.inventory_id = i2.inventory_id " +
            "    JOIN film f2 ON i2.film_id = f2.film_id " +
            "    WHERE r2.customer_id = c.customer_id " +
            "    AND f2.length > 180" +
            ") " +
            "AND NOT EXISTS (" +
            "    SELECT 1 " +
            "    FROM rental r2 " +
            "    JOIN inventory i2 ON r2.inventory_id = i2.inventory_id " +
            "    JOIN film f2 ON i2.film_id = f2.film_id " +
            "    JOIN film_category fc2 ON f2.film_id = fc2.film_id " +
            "    WHERE r2.customer_id = c.customer_id " +
            "    AND r2.rental_date < r.rental_date " +
            "    AND fc2.category_id = fc.category_id" +
            ") " +
            "ORDER BY c.last_name, c.first_name", nativeQuery = true)
    List<Query39> Query39();

}
