package com.techlead.controller.javacore1;

import com.techlead.service.core1.Level2Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/core-java-1/level-2")
@Tag(name = "Core Java 1 - Level 2", description = "APIs for Core Java 2 - Level 2")
public class Level2Controller {

    @Autowired
    private final Level2Service level2Service;


    public Level2Controller(Level2Service level2Service) {
        this.level2Service = level2Service;
    }

    @Operation(summary = "returns the second largest number in the list.", description = "Write a program that takes a list of numbers as input and returns the second largest number in the list.")
    @GetMapping("/second-largest-number")
    public ResponseEntity<?> secondLargestNumber(@RequestParam int[] arr){
        return ResponseEntity.ok(level2Service.secondLargestNumber(arr));
    }

    @Operation(summary = "returns the longest word in the list", description = "Write a program that takes a list of strings as input and returns the longest word in the list.")
    @GetMapping("/longest-word-in-list")
    public ResponseEntity<?> longestWordInStrings(@RequestParam String[] list){
        return ResponseEntity.ok(level2Service.longestWordInStrings(list));
    }

    @Operation(summary = "find the longest common subsequence of the two strings.", description = "Write a program that takes two strings as input and returns the longest common subsequence of the two strings.")
    @GetMapping("/longest-common-sequence")
    public ResponseEntity<?> findLCS(@RequestParam String str1, @RequestParam String str2){
        return ResponseEntity.ok(level2Service.findLCS(str1, str2));
    }

    @Operation(summary = "the sum of the numbers that are divisible by both 3 and 5.", description = "Write a program that takes a list of numbers as input and returns the sum of the numbers that are divisible by both 3 and 5.")
    @GetMapping("/sum-number-constraint")
    public ResponseEntity<?> sumNumbers(@RequestParam int[] arr){
        return ResponseEntity.ok(level2Service.sumNumbers(arr));
    }

    @Operation(summary = "maximum sum of any contiguous subarray", description = "Write a program that takes a list of integers as input and returns the maximum sum of any contiguous subarray within the list.")
    @GetMapping("/maximum-sum")
    public ResponseEntity<?> maxSubArraySum(@RequestParam int[] arr){
        return ResponseEntity.ok(level2Service.maxSubarraySum(arr));
    }



}
