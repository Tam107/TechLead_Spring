package com.techlead.controller.javacore2;

import com.techlead.model.Product8;
import com.techlead.service.core2.impl.Exercise8Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/core-java-2/ex8")
@Tag(name = "Core Java 2 - ex8")
public class Ex8Controller {

    private final Exercise8Service exercise8Service;

    public Ex8Controller(Exercise8Service exercise8Service) {
        this.exercise8Service = exercise8Service;
    }

    @PostMapping("/add-product")
    public ResponseEntity<?> addProduct(@RequestBody Product8 product) {
        return ResponseEntity.ok(exercise8Service.addProduct(product));
    }

    @GetMapping("/products")
    public ResponseEntity<?> showProducts() {
        return ResponseEntity.ok(exercise8Service.showProduct());
    }

    @GetMapping("/search-products")
    public ResponseEntity<?> searchProducts(String code) {
        return ResponseEntity.ok(exercise8Service.searchProduct(code));
    }


    @GetMapping("/delete-product")
    public ResponseEntity<?> deleteProduct(String code) {
        return ResponseEntity.ok(exercise8Service.deleteProduct(code));
    }

    @PutMapping("/update-product")
    public ResponseEntity<?> updateProduct(@RequestBody Product8 product) {
        return ResponseEntity.ok(exercise8Service.updateProduct(product));
    }





}
