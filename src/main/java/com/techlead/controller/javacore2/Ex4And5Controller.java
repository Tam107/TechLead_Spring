package com.techlead.controller.javacore2;

import com.techlead.service.core2.impl.Exercise4And5Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/core-java-2/ex4")
@Tag(name = "Core Java 2 - ex4")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')") // Only allow ADMIN and USER roles to access
public class Ex4And5Controller {

    private final Exercise4And5Service exercise4And5Service;


    public Ex4And5Controller(Exercise4And5Service exercise4And5Service) {
        this.exercise4And5Service = exercise4And5Service;
    }

    @GetMapping("/sort")
    public ResponseEntity<?> sort(@RequestParam List<String> arr) {
        return ResponseEntity.ok(exercise4And5Service.sort(arr));
    }

    @GetMapping("/two-sum")
    public ResponseEntity<?> twoSum(@RequestParam int[] arr, @RequestParam int target) {
        return ResponseEntity.ok(exercise4And5Service.twoSum(arr, target));
    }
}
