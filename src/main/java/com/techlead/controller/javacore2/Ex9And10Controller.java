package com.techlead.controller.javacore2;


import com.techlead.service.core2.impl.Exercise9And10Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/core-java-2/ex9")
@Tag(name = "Core Java 2 - ex9")
public class Ex9And10Controller {

    private final Exercise9And10Service exercise9And10Service;

    public Ex9And10Controller(Exercise9And10Service exercise9And10Service) {
        this.exercise9And10Service = exercise9And10Service;
    }

    @GetMapping("/check-frequency")
    public ResponseEntity<?> showProducts(@RequestParam String text, @RequestParam HashMap<String, Integer> wordFrequency ) {
        return ResponseEntity.ok(exercise9And10Service.checkWordFrequency(text, wordFrequency));
    }

    @GetMapping("/check-score")
    public ResponseEntity<?> checkScore(@RequestParam Map<String, List<Double>> scores ) {
        return ResponseEntity.ok(exercise9And10Service.checkScore(scores));
    }

}
