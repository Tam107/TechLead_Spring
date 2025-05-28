package com.techlead.controller.javacore1;

import com.techlead.service.core1.Level1Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/core-java-1/level-1")
@Tag(name = "Core Java 1 - Level 1", description = "APIs for Core Java 1 - Level 1")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')") // Only allow ADMIN and USER roles to access
public class Level1Controller {

    @Autowired
    private Level1Service level1Service;

    public Level1Controller(Level1Service level1Service){
        this.level1Service = level1Service;
    }

    @Operation(summary = "Sum of two numbers", description = "Input two number, returns the sum of two numbers")
    @GetMapping("/sum")
    public ResponseEntity<?> sum(@RequestParam int a, @RequestParam int b){
        return ResponseEntity.ok(level1Service.displaySum(a, b));
    }

    @Operation(summary = "Display String length", description = "Write a program that takes a number as input and displays its square. ")
    @GetMapping("/string-length")
    public ResponseEntity<?> displayStringLength(@RequestParam String string){
        return ResponseEntity.ok(level1Service.displayStringLength(string));
    }

    @Operation(summary = "Display Square", description = "Display String length return length of the string")
    @GetMapping("/display-square")
    public ResponseEntity<?> displaySquare(@RequestParam int num){
        return ResponseEntity.ok(level1Service.displaySquare(num));
    }

    @Operation(summary = "Display largest number", description = "Write a program that takes a list of numbers as input and displays the largest number in the list.")
    @GetMapping("/largest")
    public ResponseEntity<?> displayLargestSum(@RequestParam int[] arr){
        return ResponseEntity.ok(level1Service.displayTheLargestNum(arr));
    }

    @Operation(summary = "shortest string", description = "Write a program that takes a list of strings as input and displays the shortest string in the list.")
    @GetMapping("/shortest-string")
    public ResponseEntity<?> displayShortestString(@RequestParam String[] string){
        return ResponseEntity.ok(level1Service.displayShortestString(string));
    }

    @Operation(summary = "display sorted list", description = "Write a program that takes a list of numbers as input and sorts the list in ascending order.")
    @GetMapping("/sorted-array")
    public ResponseEntity<?> displaySortedArray(@RequestParam int[] arr){
        return ResponseEntity.ok(level1Service.sortedArray(arr));
    }

    @Operation(summary = "Display sorted string", description = "Write a program that takes a list of strings as input and sorts the list in alphabetical order.")
    @GetMapping("/sort-string")
    public ResponseEntity<?> displaySortString(@RequestParam String[] arr){
        return ResponseEntity.ok(level1Service.sort(arr));
    }

    @Operation(summary = "Find the median of an array", description = "Write a program that takes a comma-separated list of numbers as input (e.g., '1,3,5') and returns the median of the numbers.")
    @GetMapping("/find-median")
    public ResponseEntity<?> findMedian(@RequestParam("arr") String arr) {
        try {
            // Parse comma-separated string into int[]
            int[] numbers = Arrays.stream(arr.split(","))
                    .map(String::trim) // Remove spaces (e.g., "1, 3, 5")
                    .mapToInt(Integer::parseInt)
                    .toArray();
            return ResponseEntity.ok(level1Service.findMedian(numbers));
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid input: all values must be integers (e.g., '1,3,5')");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid input format: use comma-separated integers (e.g., '1,3,5')");
        }
    }

    @Operation(summary = "Check word's length", description = "Write a program that takes a string as input and returns the number of words in the string")
    @GetMapping("/check-word-length")
    public ResponseEntity<?> checkWordLength(@RequestParam String word){
        return ResponseEntity.ok(level1Service.checkWordLength(word));
    }

    @Operation(summary = "Check letter in word", description = "Write a program that takes a list of strings as input and returns the number of strings that contain the letter 'a'.")
    @GetMapping("/check-letter-in-word")
    public ResponseEntity<?> checkLetterInWord(@RequestParam String[] words){
        return ResponseEntity.ok(level1Service.checkLetterInWord(words));
    }



}
