package com.techlead.controller.javacore2;

import com.techlead.service.core2.impl.Exercise6And7Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/core-java-2/ex5")
@Tag(name = "Core Java 2 - ex5")
public class Ex6And7Controller {

    private final Exercise6And7Service exercise6And7Service;

    public Ex6And7Controller(Exercise6And7Service exercise6And7Service) {
        this.exercise6And7Service = exercise6And7Service;
    }

    @GetMapping("/two-sum")
    public ResponseEntity<?> twoSum(@RequestParam int[] arr, @RequestParam int target) {
        return ResponseEntity.ok(exercise6And7Service.twoSum(arr, target));
    }

    @GetMapping("/student-score")
    public ResponseEntity<?> calculateStudentScore(@RequestParam HashMap<String, List<Double>> studentScores) {
        return ResponseEntity.ok(exercise6And7Service.calculateStudentScore(studentScores));
    }



}
