package com.techlead.controller.javacore2;

import com.techlead.service.core2.Exercise2Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@RequestMapping("/api/v1/core-java-2/ex2")
@Tag(name = "Core Java 2 ex 2")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')") // Only allow ADMIN and USER roles to access
public class Ex2Controller {

    private final Exercise2Service exercise2Service;

    public Ex2Controller(Exercise2Service exercise2Service) {
        this.exercise2Service = exercise2Service;
    }

    @GetMapping("/add-countries")
    public ResponseEntity<?> addElement(@RequestParam String... str) {
        return ResponseEntity.ok(exercise2Service.addCountries(str));
    }

        @GetMapping("/display-countries")
    public ResponseEntity<?> displaySet() {
        return ResponseEntity.ok(exercise2Service.displaySet());
    }

        @GetMapping("/check-existing")
    public ResponseEntity<?> checkExistingEle(@RequestParam String element) {
        return ResponseEntity.ok(exercise2Service.checkExisting(element));
    }

        @GetMapping("/remove-element")
    public ResponseEntity<?> removeElement(@RequestParam String element) {
        return ResponseEntity.ok(exercise2Service.removeElement(element));
    }


}
