package com.techlead.controller.sakila;

import com.techlead.repository.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sakila")
@Tag(name = "Sakila Query")
@PreAuthorize("hasRole('ADMIN')")
public class SakilaController {
    private final ActorRepository actorRepository;
    private final CustomerRepository customerRepository;
    private final FilmRepository filmRepository;
    private final RentalRepository rentalRepository;
    private final StoreRepository storeRepository;

    private final PaymentRepository paymentRepository;

    public SakilaController(ActorRepository actorRepository, CustomerRepository customerRepository, FilmRepository filmRepository, RentalRepository rentalRepository, StoreRepository storeRepository, PaymentRepository paymentRepository) {
        this.actorRepository = actorRepository;
        this.customerRepository = customerRepository;
        this.filmRepository = filmRepository;
        this.rentalRepository = rentalRepository;
        this.storeRepository = storeRepository;
        this.paymentRepository = paymentRepository;
    }

    @GetMapping("/query-1-1")
    public ResponseEntity<?> query1_1() {
        return ResponseEntity.ok(actorRepository.findALlActorNames());
    }

    @GetMapping("/query-1-2")
    public ResponseEntity<?> query1_2() {
        return ResponseEntity.ok(filmRepository.findAllFilmDetails());
    }

    @GetMapping("/query-1-3")
    public ResponseEntity<?> query1_3() {
        return ResponseEntity.ok(rentalRepository.findTop5RentedFilms(Pageable.ofSize(5)));
    }

    @GetMapping("/query-1-4")
    public ResponseEntity<?> query1_4() {
        return ResponseEntity.ok(rentalRepository.findAverageRentalDurationByCategory());
    }

    @GetMapping("/query-1-5")
    public ResponseEntity<?> query1_5() {
        return ResponseEntity.ok(rentalRepository.findCustomersRentingInPeriod(RentalRepository.start, RentalRepository.end));
    }

    @GetMapping("/query-1-6")
    public ResponseEntity<?> query1_6() {
        return ResponseEntity.ok(paymentRepository.findStoreRevenueFor2021());
    }

    @GetMapping("/query-1-7")
    public ResponseEntity<?> query1_7() {
        return ResponseEntity.ok(actorRepository.findActorsWithMoreThan20Films());
    }

    @GetMapping("/query-1-8")
    public ResponseEntity<?> query1_8() {
        return ResponseEntity.ok(filmRepository.findPg13FilmsLongerThan120Minutes());
    }

    @GetMapping("/query-2-1")
    public ResponseEntity<?> query2_1() {
        return ResponseEntity.ok(actorRepository.findTop10CustomersByRevenue(Pageable.ofSize(5)));
    }

    @GetMapping("/query-2-2")
    public ResponseEntity<?> query2_2() {
        return ResponseEntity.ok(rentalRepository.findCustomersRentingAllCategories());
    }

    @GetMapping("/query-2-3")
    public ResponseEntity<?> query2_3() {
        return ResponseEntity.ok(filmRepository.findNeverReturnedFilms());
    }

    @GetMapping("/query-2-4")
    public ResponseEntity<?> query2_4() {
        return ResponseEntity.ok(actorRepository.findActorsInAllCategories());
    }

    @GetMapping("/query-2-5")
    public ResponseEntity<?> query2_5() {
        return ResponseEntity.ok(rentalRepository.findActorsInAllCategories());
    }

    @GetMapping("/query-2-6")
    public ResponseEntity<?> query2_6() {
        return ResponseEntity.ok(actorRepository.findActorRevenue());
    }

    @GetMapping("/query-2-7")
    public ResponseEntity<?> query2_7() {
        return ResponseEntity.ok(actorRepository.findActorsInRButNotG());
    }

    @GetMapping("/query-2-8")
    public ResponseEntity<?> query2_8() {
        return ResponseEntity.ok(filmRepository.findFilmsRentedByManyCustomersOnce());
    }

    @GetMapping("/query-2-9")
    public ResponseEntity<?> query2_9() {
        return ResponseEntity.ok(customerRepository.query29());
    }

    @GetMapping("/query-2-10")
    public ResponseEntity<?> query2_10() {
        return ResponseEntity.ok(filmRepository.query210());
    }

    @GetMapping("/query-3-1")
    public ResponseEntity<?> query3_1() {
        return ResponseEntity.ok(actorRepository.Query31());
    }

    @GetMapping("/query-3-2")
    public ResponseEntity<?> query3_2() {
        return ResponseEntity.ok(actorRepository.Query32());
    }

    @GetMapping("/query-3-3")
    public ResponseEntity<?> query3_3() {
        return ResponseEntity.ok(rentalRepository.Query33());
    }
    @GetMapping("/query-3-4")
    public ResponseEntity<?> query3_4() {
        return ResponseEntity.ok(rentalRepository.Query34());
    }

    @GetMapping("/query-3-5")
    public ResponseEntity<?> query3_5() {
        return ResponseEntity.ok(rentalRepository.Query35());
    }

    @GetMapping("/query-3-6")
    public ResponseEntity<?> query3_6() {
        return ResponseEntity.ok(actorRepository.Query36());
    }

    @GetMapping("/query-3-7")
    public ResponseEntity<?> query3_7() {
        return ResponseEntity.ok(rentalRepository.Query37());
    }

    @GetMapping("/query-3-8")
    public ResponseEntity<?> query3_8() {
        return ResponseEntity.ok(filmRepository.Query38());
    }

    @GetMapping("/query-3-9")
    public ResponseEntity<?> query3_9() {
        return ResponseEntity.ok(rentalRepository.Query39());
    }

    @GetMapping("/query-3-10")
    public ResponseEntity<?> query3_10() {
        return ResponseEntity.ok(actorRepository.Query310());
    }

}
