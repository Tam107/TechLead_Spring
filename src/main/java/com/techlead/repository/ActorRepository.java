package com.techlead.repository;

import com.techlead.dto.request.query1.ActorDTO;
import com.techlead.dto.request.query1.Query17;
import com.techlead.dto.request.query2.Query21;
import com.techlead.dto.request.query2.Query24;
import com.techlead.dto.request.query2.Query26;
import com.techlead.dto.request.query2.Query27;
import com.techlead.dto.request.query3.Query31;
import com.techlead.dto.request.query3.Query310;
import com.techlead.dto.request.query3.Query32;
import com.techlead.dto.request.query3.Query36;
import com.techlead.model.sakila.Actor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    // query 1.1
    @Query("SELECT new com.techlead.dto.request.query1.ActorDTO(a.firstName, a.lastName) from Actor a")
    List<ActorDTO> findALlActorNames();

    @Query("SELECT new com.techlead.dto.request.query1.Query17(a.firstName, a.lastName) " +
            "FROM Actor a JOIN Film f GROUP BY a.actorId, a.firstName, a.lastName HAVING COUNT(f) > 20")
    List<Query17> findActorsWithMoreThan20Films();


    // Level 2 Queries
    //select c.first_name, c.last_name, sum(p.amount) as total_revenue from customer c join payment p on c.customer_id = p.customer_id
    //group by c.customer_id, c.first_name, c.last_name order by total_revenue desc limit 10;
    @Query("SELECT new com.techlead.dto.request.query2.Query21(c.firstName, c.lastName, SUM(p.amount)) " +
            "FROM Customer c JOIN Payment p on c.customerId = p.customer.customerId " +
            "group by c.customerId, c.firstName, c.lastName ORDER BY SUM(p.amount) DESC")
    List<Query21> findTop10CustomersByRevenue(Pageable pageable);

    @Query("SELECT new com.techlead.dto.request.query2.Query24(a.firstName, a.lastName) " +
            "FROM Actor a JOIN a.filmActors fa JOIN fa.film.filmCategories fc " +
            "GROUP BY a.actorId, a.firstName, a.lastName " +
            "HAVING COUNT(DISTINCT fc.category.categoryId) = (SELECT COUNT(c) FROM Category c)")
    List<Query24> findActorsInAllCategories();

    // select a.first_name, a.last_name, SUM(p.amount) as total_revenue from actor a
    //join film_actor fa on a.actor_id = fa.actor_id
    //join inventory i on fa.film_id = i.film_id
    //join rental r on i.inventory_id = r.inventory_id
    //join payment p on r.rental_id = p.rental_id
    //group by a.actor_id, a.first_name, a.last_name
    //order by total_revenue desc;
    @Query("SELECT new com.techlead.dto.request.query2.Query26(a.firstName, a.lastName, SUM(p.amount)) as total_revenue " +
            "FROM Actor a JOIN FilmActor fa on a.actorId = fa.actor.actorId JOIN Inventory i on fa.film.filmId = i.film.filmId" +
            " JOIN Rental r on i.inventoryId = r.inventory.inventoryId JOIN Payment p on r.rentalId = p.rentalId " +
            "GROUP BY a.actorId, a.firstName, a.lastName ORDER BY SUM(p.amount) DESC")
    List<Query26> findActorRevenue();

    @Query(value = "SELECT DISTINCT a.first_name AS firstName, a.last_name AS lastName " +
            "FROM actor a " +
            "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
            "JOIN film f ON fa.film_id = f.film_id " +
            "WHERE f.rating = 'R' " +
            "AND NOT EXISTS (" +
            "    SELECT 1 FROM film_actor fa2 " +
            "    JOIN film f2 ON fa2.film_id = f2.film_id " +
            "    WHERE fa2.actor_id = a.actor_id AND f2.rating = 'G'" +
            ")", nativeQuery = true)
    List<Query27> findActorsInRButNotG();

    // 3.1
    @Query(value = "SELECT CONCAT(a.first_name, ' ', a.last_name) AS actorName, c.name AS categoryName, " +
            "ROUND(AVG(f.rental_duration), 2) AS avgRentalDuration " +
            "FROM actor a " +
            "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
            "JOIN film f ON fa.film_id = f.film_id " +
            "JOIN film_category fc ON f.film_id = fc.film_id " +
            "JOIN category c ON fc.category_id = c.category_id " +
            "GROUP BY a.actor_id, c.category_id " +
            "ORDER BY CONCAT(a.first_name, ' ', a.last_name), c.name", nativeQuery = true)
    List<Query31> Query31();

    @Query(value = "SELECT DISTINCT CONCAT(a.first_name, ' ', a.last_name) AS actorName " +
            "FROM actor a " +
            "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
            "JOIN film f ON fa.film_id = f.film_id " +
            "WHERE f.rating = 'R' AND f.length > 120 " +
            "AND NOT EXISTS (" +
            "    SELECT 1 FROM film_actor fa2 " +
            "    JOIN film f2 ON fa2.film_id = f2.film_id " +
            "    WHERE fa2.actor_id = a.actor_id AND f2.rating = 'G'" +
            ")", nativeQuery = true)
    List<Query32> Query32();


    @Query(value = "SELECT fa1.actor_id AS actor1_id, " +
            "fa2.actor_id AS actor2_id, " +
            "COUNT(*) AS shared_film_count " +
            "FROM film_actor fa1 " +
            "JOIN film_actor fa2 ON fa1.film_id = fa2.film_id " +
            "WHERE fa1.actor_id < fa2.actor_id " +
            "GROUP BY fa1.actor_id, fa2.actor_id", nativeQuery = true)
    List<Query36> Query36();


    @Query(value = "SELECT DISTINCT a.first_name AS firstName, a.last_name AS lastName " +
            "FROM actor a " +
            "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
            "JOIN film f ON fa.film_id = f.film_id " +
            "WHERE f.rating = 'PG-13' AND f.length > 120 " +
            "AND EXISTS (" +
            "    SELECT 1 FROM film_actor fa2 " +
            "    JOIN film f2 ON fa2.film_id = f2.film_id " +
            "    WHERE fa2.actor_id = a.actor_id AND f2.rating = 'R' AND f2.length < 90" +
            ")", nativeQuery = true)
    List<Query310> Query310();
}
