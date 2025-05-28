package com.techlead.controller.javacore2;

import com.techlead.service.core2.Exercise3Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/core-java-2/ex3")
@Tag(name = "Core Java 2 - ex3")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')") // Only allow ADMIN and USER roles to access
public class Ex3Controller {

    private final Exercise3Service exercise3Service;

    public Ex3Controller(Exercise3Service exercise3Service) {
        this.exercise3Service = exercise3Service;
    }

    @GetMapping("/add-person")
    public ResponseEntity<?> addPerson(@RequestParam String name, @RequestParam int age) {
        return ResponseEntity.ok(exercise3Service.addPerson(name, age));
    }

    @GetMapping("/display-person")
    public ResponseEntity<?> displayPerson() {
        return ResponseEntity.ok(exercise3Service.displaySet());
    }

    @GetMapping("/find-age-by-name")
    public ResponseEntity<?> findAgeByName(@RequestParam String name) {
        return ResponseEntity.ok(exercise3Service.findAgeByName(name));
    }

    @GetMapping("/remove-person")
    public ResponseEntity<?> removePerson(@RequestParam String name) {
        return ResponseEntity.ok(exercise3Service.removePerson(name));
    }

    @GetMapping("/check-existing-person")
    public ResponseEntity<?> checkExistingPerson(@RequestParam String name) {
        return ResponseEntity.ok(exercise3Service.checkExist(name));
    }

}
