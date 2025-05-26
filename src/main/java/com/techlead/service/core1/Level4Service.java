package com.techlead.service.core1;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Level4Service {


    // 4.1
    public int[] bubbleSort(int arr[]){
        int i, j, temp;
        boolean swapped;
        int n = arr.length;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
        return arr;
    }

    // 4.2
    public int findDistinctSub(int[] arr, int target) {
        int count = 0;
        for(int j = 0; j < arr.length; j++){
            for (int x = j ; x < arr.length; x++){
                if (arr[j] + arr[x] == target){
                    count++;
                }
            }
        }

        return count;
    }

    // 4.3
    public int findLongestCommonSubstringLength(List<String> strings) {
        // Handle edge cases
        if (strings == null || strings.isEmpty()) {
            return 0;
        }
        if (strings.size() == 1) {
            return strings.get(0).length();
        }

        // Find the shortest string
        String shortest = strings.get(0);
        for (String s : strings) {
            if (s.length() < shortest.length()) {
                shortest = s;
            }
        }

        // Try all substrings of the shortest string, starting from longest
        int maxLength = 0;
        for (int len = shortest.length(); len > 0; len--) {
            // Generate all substrings of length len
            for (int start = 0; start + len <= shortest.length(); start++) {
                String substring = shortest.substring(start, start + len);
                // Check if substring exists in all strings
                boolean foundInAll = true;
                for (String s : strings) {
                    if (!s.contains(substring)) {
                        foundInAll = false;
                        break;
                    }
                }
                if (foundInAll) {
                    maxLength = len;
                    break; // Found a valid substring of this length, no need to check shorter ones
                }
            }
            if (maxLength > 0) {
                break; // Found the longest valid substring
            }
        }

        return maxLength;
    }

    // 4.6
    public long maxProductOfThree(List<Integer> numbers) {
        // Handle edge cases
        if (numbers == null || numbers.size() < 3) {
            throw new IllegalArgumentException("List must contain at least three numbers");
        }

        // Convert list to array and sort
        int[] arr = numbers.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);
        int n = arr.length;

        // Maximum product is either:
        // 1. Three largest numbers
        // 2. Two smallest numbers (if negative) and the largest number
        return Math.max(
                (long) arr[n - 1] * arr[n - 2] * arr[n - 3],
                (long) arr[0] * arr[1] * arr[n - 1]
        );
    }

    // 4.7
    public List<String> sortByDistinctWords(List<String> strings) {
        if (strings == null){
            return Collections.emptyList();
        }

        return strings.stream()
                .sorted((s1, s2)->{
                    int distinctWords1 = countDistinctWords(s1);
                    int distinctWords2 = countDistinctWords(s1);

                    if (distinctWords1 != distinctWords2){
                        return Integer.compare(distinctWords2, distinctWords1);
                    }
                    if (s1.length() != s2.length()){
                        return Integer.compare(s2.length(), s1.length());
                    }
                    return s1.compareTo(s2); // return equals or greater or less 0
                }).collect(Collectors.toList());
    }

    // 4.9
    public int longestIncreasingSubsequence(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return 0;
        }

        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums.get(i) > nums.get(j) && nums.get(i) - nums.get(j) == 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    // 4.10
    public String[] findLargestOverlap(List<String> testStrings,int k) {
        if (testStrings == null || testStrings.size() < 2 || k < 1){
            return new String[]{"","",""};
        }

        String string1 = "";
        String string2 = "";
        String largestCommonString ="";
        int largestOverlap = 0;
        for(int i = 0; i< testStrings.size(); i++){
            for (int j = i + 1; j< testStrings.size();j++){
                String s1 = testStrings.get(i);
                String s2 = testStrings.get(j);

                // find the largest common substring of at least k
                String commonSubString = findLongestCommonSubstring(s1, s2, k);
                if (commonSubString.length() > largestOverlap){
                    largestOverlap = commonSubString.length();
                    largestCommonString = commonSubString;
                    string1 = s1;
                    string2 = s2;
                }
            }
        }
        return new String[]{string1, string2, largestCommonString};
    }

    /**
     * Find the longest common substring between two strings that is at least k characters long.
     *
     * @param s1 First string
     * @param s2 Second string
     * @param k Minimum length of substring
     * @return The longest common substring, or empty string if none exists
     */
    private static String findLongestCommonSubstring(String s1, String s2, int k) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;
        int endIndex = 0;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > maxLength && dp[i][j] >= k) {
                        maxLength = dp[i][j];
                        endIndex = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength >= k ? s1.substring(endIndex - maxLength, endIndex) : "";
    }

    private static int countDistinctWords(String s) {
        if (s == null || s.trim().isEmpty()){
            return 0;
        }
        String[] words = s.trim().toLowerCase().split("\\s+");
        return (int) Arrays.stream(words)
                .filter(word -> !word.isEmpty())
                .distinct().count();
    }
}
