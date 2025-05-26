package com.techlead.controller.javacore1;

import com.techlead.service.core1.Level3Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/core-java-1/level-3")
@Tag(name = "Core Java 1 - Level 3", description = "APIs for Core Java 1 - Level 3")
public class Level3Controller {


    private Level3Service level3Service;

    public Level3Controller(Level3Service level3Service){
        this.level3Service = level3Service;
    }

    @Operation(summary = "Find the maximum difference between any two elements in the list", description = "Write a program that takes a list of integers as input and returns the maximum difference between any two elements in the list.")
    @GetMapping("/maximum-different")
    public ResponseEntity<?> maximumDiffer(@RequestParam int[] arr){
        return ResponseEntity.ok(level3Service.maximumDiffer(arr));
    }

    @Operation(summary = "Find longest increasing subsequence of the numbers.", description = "Write a program that takes a list of integers as input and returns the longest increasing subsequence of the numbers. ")
    @GetMapping("/find-lis")
    public ResponseEntity<?> findLIS(@RequestParam int[] arr){
        return ResponseEntity.ok(level3Service.findLongestIncreasingSubsequence(arr));
    }

    @Operation(summary = "Find Strings with largest overlap", description = "Write a program that takes a list of strings as input and returns the two strings with the largest overlap of characters.")
    @GetMapping("/largest-overlap")
    public ResponseEntity<?> findStringsWithLO(@RequestParam String[] str){
        return ResponseEntity.ok(level3Service.findStringsWithLargestOverlap(str));


    }@Operation(summary = "Find the second smallest of the list", description = "Write a program that takes a list of numbers as input and returns the smallest positive integer that cannot be represented as the sum of any subset of the list.")
    @GetMapping("/smallest")
    public ResponseEntity<?> findSmallest(@RequestParam int[] arr){
        return ResponseEntity.ok(level3Service.findSmallest(arr));
    }

    @Operation(summary = "Find the median of two lists", description = "Write a program that takes two lists of integers as input and returns the median of the combined list.")
    @GetMapping("/median-combined-list")
    public ResponseEntity<?> findMedianOfCombinedList(@RequestParam List<Integer> list1, @RequestParam List<Integer> list2){
        return ResponseEntity.ok(level3Service.findMedianOfTwoLists(list1, list2));
    }

    @Operation(summary = "Find the longest palindrome of strings", description = "Write a program that takes a string as input and returns the length of the longest palindrome that can be formed by rearranging the characters in the string.")
    @GetMapping("/find-palindrome")
    public ResponseEntity<?> finalPalindrome(@RequestParam String s){
        return ResponseEntity.ok(level3Service.finalPalindrome(s));
    }

    @Operation(summary = "returns the list sorted by the number of distinct characters in each string", description = "Write a program that takes a list of strings as input and returns the list sorted by the number of distinct characters in each string, with the shortest strings appearing first.")
    @GetMapping("/sort-by-distinct-character")
    public ResponseEntity<?> sortByDistinctCharacter(@RequestParam List<String> words){
        return ResponseEntity.ok(level3Service.sortByDistinctCharacters(words));
    }


}
