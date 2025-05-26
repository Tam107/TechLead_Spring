package com.techlead.controller.javacore1;

import com.techlead.service.core1.Level4Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/core-java-1/level-4")
@Tag(name = "Core Java 1 - Level 4", description = "APIs for Core Java 1 - Level 4")
public class Level4Controller {

    private Level4Service level4Service;

    public Level4Controller(Level4Service level4Service) {
        this.level4Service = level4Service;
    }

    @Operation(summary = "sort the list in ascending order using bubble sort.", description = "Write a program that takes a list of integers as input and returns the minimum number of moves required to sort the list in ascending order using bubble sort.")
    @GetMapping("/bubble-sort")
    public ResponseEntity<?> bubbleSort(@RequestParam int[] arr) {
        return ResponseEntity.ok(level4Service.bubbleSort(arr));
    }

    @Operation(summary = "returns the number of distinct subsequences of the list that sum up to a target value", description = "Write a program that takes a list of integers as input and returns the number of distinct subsequences of the list that sum up to a target value.")
    @GetMapping("/find-distinct-sub")
    public ResponseEntity<?> findDistinctSub(@RequestParam int[] arr, @RequestParam int target) {
        return ResponseEntity.ok(level4Service.findDistinctSub(arr, target));
    }

    @Operation(summary = "returns the length of the longest substring that appears in every string in the list.", description = "Write a program that takes a list of strings as input and returns the length of the longest substring that appears in every string in the list.")
    @GetMapping("/longest-common-string-length")
    public ResponseEntity<?> findLongestCommonSubstringLength(@RequestParam List<String> strings) {
        return ResponseEntity.ok(level4Service.findLongestCommonSubstringLength(strings));
    }


    @Operation(summary = "maximum product", description = "Write a program that takes a list of integers as input and returns the maximum product of any three distinct elements in the list.")
    @GetMapping("/max-product-of-three")
    public ResponseEntity<?> maxProductOfThree(@RequestParam List<Integer> numbers) {
        return ResponseEntity.ok(level4Service.maxProductOfThree(numbers));
    }

    @Operation(summary = "sortByDistinctWords", description = "Write a program that takes a list of strings as input and returns the list sorted by the number of distinct words in each string, with the longest strings appearing first.")
    @GetMapping("/sort-by-distinct-word")
    public ResponseEntity<?> sortByDistinctWords(@RequestParam List<String> strings) {
        return ResponseEntity.ok(level4Service.sortByDistinctWords(strings));
    }

    @Operation(summary = "returns the length of the longest increasing subsequence of the numbers", description = "Write a program that takes a list of integers as input and returns the length of the longest increasing subsequence of the numbers, with the additional constraint that no two adjacent elements in the subsequence can differ by more than 1. ")
    @GetMapping("/longest-increasing-sequence")
    public ResponseEntity<?> longestIncreasingSubsequence(@RequestParam List<Integer> nums) {
        return ResponseEntity.ok(level4Service.longestIncreasingSubsequence(nums));
    }

    @Operation(summary = "sort the list in ascending order using bubble sort.", description = "Write a program that takes a list of integers as input and returns the minimum number of moves required to sort the list in ascending order using bubble sort.")
    @GetMapping("/find-largest-overlap")
    public ResponseEntity<?> findLargestOverlap(@RequestParam List<String> testStrings,@RequestParam int k) {
        return ResponseEntity.ok(level4Service.findLargestOverlap(testStrings, k));
    }


}
