package com.techlead.controller.javacore2;

import com.techlead.service.core2.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/core-java-2/ex1")
@Tag(name = "Core Java 2 ex 1")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')") // Only allow ADMIN and USER roles to access
public class Ex1Controller {


    private final Exercise1Service exercise1Service;

    public Ex1Controller(Exercise1Service exercise1Service) {
        this.exercise1Service = exercise1Service;
    }


    @GetMapping("/add-element")
    public ResponseEntity<?> addElement(@RequestParam int element) {
        return ResponseEntity.ok(exercise1Service.addElementToList(element));
    }


    @GetMapping("/display-element")
    public ResponseEntity<?> displayEle() {
        return ResponseEntity.ok(exercise1Service.displayElementsInList());
    }


    @GetMapping("/remove-element")
    public ResponseEntity<?> removeElement(@RequestParam int element) {
        return ResponseEntity.ok(exercise1Service.removeElementFromList(element));
    }


    @GetMapping("/sum-element")
    public ResponseEntity<?> sumElement() {
        return ResponseEntity.ok(exercise1Service.sumOfElementsInList());
    }

    @GetMapping("/max-element")
    public ResponseEntity<?> maxElement() {
        return ResponseEntity.ok(exercise1Service.maxElementInList());
    }

    @GetMapping("/min-element")
    public ResponseEntity<?> minElement() {
        return ResponseEntity.ok(exercise1Service.minElementInList());
    }

    @GetMapping("/check-element")
    public ResponseEntity<?> checkEle(@RequestParam int element) {
        return ResponseEntity.ok(exercise1Service.checkElementInList(element));
    }


}
