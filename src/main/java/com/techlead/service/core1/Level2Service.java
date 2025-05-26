package com.techlead.service.core1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Level2Service {


    // 2.1
    public int secondLargestNumber(int[] arr){
        int length = arr.length;
        Arrays.sort(arr);
        return arr[length -2];
    }

    // 2.2
    public String longestWordInStrings(String[] str){
        int length = str.length;
        int longest = str[0].length();
        String longestWord = str[0];
        for(String s : str){
            if(s.length() > longest){
                longestWord = s;
                longest = s.length();
            }
        }
        return longestWord;
    }

    //2.3 Longest common
    public String findLCS(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Store length of LCS for all subproblems
        int[][] lengths = new int[m + 1][n + 1];

        // Build the lengths table in bottom-up fashion
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    lengths[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    lengths[i][j] = lengths[i - 1][j - 1] + 1;
                } else {
                    lengths[i][j] = Math.max(lengths[i - 1][j], lengths[i][j - 1]);
                }
            }
        }

        // Create a character array to store the LCS
        int lcsLength = lengths[m][n];
        char[] lcs = new char[lcsLength];

        // Start from the bottom right corner and collect characters
        int i = m, j = n;
        int index = lcsLength - 1;

        while (i > 0 && j > 0) {
            // If current characters match, they are part of LCS
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                lcs[index] = text1.charAt(i - 1);
                i--;
                j--;
                index--;
            }
            // If not, move in the direction of larger value
            else if (lengths[i - 1][j] > lengths[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return new String(lcs);
    }

    // 2.4 returns the sum of the numbers that are divisible by both 3 and 5.
    public List<Integer> sumNumbers(int[] list){
       int length = list.length;
        List<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i< length; i++){
            if (list[i] % 3 == 0 && list[i] % 5 == 0){
                arrayList.add(list[i]);
            }
        }

        return arrayList;
    }

    // 2.5
    public int maxSubarraySum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // Handle edge case for empty or null array
        }

        int maxCurrent = nums[0];
        int maxGlobal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }

        return maxGlobal;
    }
}
