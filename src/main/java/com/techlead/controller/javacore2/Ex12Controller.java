package com.techlead.controller.javacore2;

import com.techlead.service.core2.Exercise12Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/core-java-2/ex12")
@Tag(name = "Core Java 2 - ex12")
public class Ex12Controller {

    private final Exercise12Service exercise12Service;

    public Ex12Controller(Exercise12Service exercise12Service) {
        this.exercise12Service = exercise12Service;
    }

    @GetMapping("/sort-by-name")
    public ResponseEntity<?> sortByName() {
        return ResponseEntity.ok(exercise12Service.sortByName());
    }

    @GetMapping("/sort-by-price")
    public ResponseEntity<?> sortByPrice() {
        return ResponseEntity.ok(exercise12Service.sortByPrice());
    }

    @GetMapping("/sort-by-date-manu")
    public ResponseEntity<?> sortByManufacturerDate() {
        return ResponseEntity.ok(exercise12Service.sortByManufactureDate());
    }

    @GetMapping("/sort-by-price-manu-date")
    public ResponseEntity<?> sortByPriceAndManufactureDate() {
        return ResponseEntity.ok(exercise12Service.sortByPriceAndManufactureDate());
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.ok(exercise12Service.getProducts());
    }


}
