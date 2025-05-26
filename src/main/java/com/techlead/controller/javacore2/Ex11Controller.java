package com.techlead.controller.javacore2;

import com.techlead.service.core2.impl.Exercise11Service;
import com.techlead.service.core2.impl.Exercise9And10Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/core-java-2/ex11")
@Tag(name = "Core Java 2 - ex11")
public class Ex11Controller {

    private final Exercise11Service exercise11Service;

    public Ex11Controller(Exercise11Service exercise11Service) {
        this.exercise11Service = exercise11Service;
    }

    @GetMapping("/search-word")
    public ResponseEntity<?> searchWord(@RequestParam String word) {
        return ResponseEntity.ok(exercise11Service.searchWord(word));
    }

    @GetMapping("/add-word")
    public ResponseEntity<?> addWord(@RequestParam String word, @RequestParam String meaning) {
        return ResponseEntity.ok(exercise11Service.addWord(word, meaning));
    }




}
