package com.techlead.controller;

import com.techlead.service.core3.Core3Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/core-java-3")
@Tag(name = "Core Java 3")
public class Core3Controller {

    private final Core3Service core3Service;

    public Core3Controller(Core3Service core3Service) {
        this.core3Service = core3Service;
    }

    @GetMapping("/infix-to-postfix")
    public ResponseEntity<?> infixToPostfix(@RequestParam String exp) {
        return ResponseEntity.ok(core3Service.convertToPostfix(exp));
    }
}
