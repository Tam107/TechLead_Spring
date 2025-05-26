package com.techlead.service.core1;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Level1Service {

    // 1.1
    public int displaySum(int n1, int n2) {
        return n1 + n2;
    }

    //1.2
    public int displayStringLength(String input) {
        return input.length();
    }

    // 1.3
    public int displaySquare(int num) {
        return num * num;
    }

    // 1.4
    public int displayTheLargestNum(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // 1.5
    public String displayShortestString(String[] arr) {
        if (arr.length < 1) {
            return "";
        }

        String shortest = arr[0];
        for (String s : arr) {
            if (s.length() < shortest.length()) {
                shortest = s;
            }
        }
        return shortest;
    }

    // 1.6
    public int[] sortedArray(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    // 1.7
    public String[] sort(String[] arr) {
        return Arrays.stream(arr).sorted().toArray(String[]::new);
    }

    // 1.8
    public int findMedian(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        // Handle empty array
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        Arrays.sort(arr);
        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2;
        }

        return arr[arr.length / 2];
    }

    // 1.9
    public int checkWordLength(String word){
        String[] splitWord = word.split("\\s+");
        return splitWord.length;
    }

    // 1.10
    public int checkLetterInWord(String[] words){
        int count = 0;
        for(int i = 0; i < words.length; i++){
            if(words[i] != null && words[i].contains("a")){
                count++;
            }
        }
        return count;
    }
}
