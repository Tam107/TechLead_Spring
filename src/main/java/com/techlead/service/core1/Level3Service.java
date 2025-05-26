package com.techlead.service.core1;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Level3Service {


    // 3.1
    public int secondSmallest(int[] arr){
        if (arr.length <= 1 ){
            return -1;
        }
        Arrays.sort(arr);
        return arr[1];
    }

    // 3.2
    public int maximumDiffer(int[] arr){
        Arrays.sort(arr);
        int maximumDiffer = 1;
        for (int i = 0; i < arr.length; i++){
            if (i == arr.length -1){
                break;
            }else {
                if ((arr[i + 1] - arr[i]) > maximumDiffer){
                    maximumDiffer = arr[i + 1] - arr[i];
                }
            }
        }
        return maximumDiffer;
    }

    // 3.3
    public int findLongestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        // Tạo mảng dp để lưu độ dài của LIS tại mỗi vị trí
        int[] dp = new int[n];

        // Khởi tạo tất cả các phần tử trong dp là 1 (mỗi phần tử là LIS)
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Tính LIS cho từng phần tử
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    int d = dp[j] +1;
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // Tìm độ dài lớn nhất trong mảng dp
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }


    // 3.4
    public String[] findStringsWithLargestOverlap(String[] strings) {
        int maxOverlap = 0;
        String[] result = new String[2];

        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                int overlap = countCommonCharacters(strings[i], strings[j]);
                if (overlap > maxOverlap) {
                    maxOverlap = overlap;
                    result[0] = strings[i];
                    result[1] = strings[j];
                }
            }
        }
        return result;
    }

    private static int countCommonCharacters(String s1, String s2) {
        // Set for saving character with first string
        Set<Character> set1 = new HashSet<>();
        for(char c : s1.toCharArray()){
            set1.add(c);
        }
        int count = 0;
        for(char c : s2.toCharArray()){
            if (set1.contains(c)){
                count++;
            }
        }
        return count;
    }

    // 3.5
    public int findSmallest(int[] numbers) {
        int smallest = 1;
        for(int num : numbers){
            if (num > smallest){
                break;
            }
            smallest += num;
        }
        return smallest;
    }

    // 3.6
    public int findMedianOfTwoLists(List<Integer> arr1, List<Integer> arr2){
        List<Integer> combinedList = new ArrayList<>(arr1);
        combinedList.addAll(arr2);
        Collections.sort(combinedList);
        int size = combinedList.size();
        int median = 0;
        if(size % 2 == 1){
            median = combinedList.get(size / 2);
        }
        else {
            int mid1 = combinedList.get(size / 2 -1);
            int mid2 = combinedList.get(size / 2);
            median = (mid1 + mid2) /2;
        }

        return median;
    }

    // 3.7
    public String finalPalindrome(String s) {
        String[] s1 = s.split("\\s");
        StringBuilder newStr = new StringBuilder();
        String finalStr = " ";
        for(int i = 0; i< s1.length;i++){
            newStr.append(s1[i].toLowerCase());
            if (checkPalindrome(newStr.toString())){
                finalStr = newStr.toString();
            }
        }
        return finalStr;
    }

    private static boolean checkPalindrome(String input){

        StringBuilder tmp = new StringBuilder();
        tmp.append(input);
        tmp.reverse();

        return input.equals(tmp.toString());
    }

    // 3.10
    public List<String> sortByDistinctCharacters(List<String> words) {
        words.sort((word1, word2) -> {
            int distinctCount1 = countDistinctCharacters(word1);
            int distinctCount2 = countDistinctCharacters(word2);
            if (distinctCount1 != distinctCount2) {
                return Integer.compare(distinctCount1, distinctCount2);
            } else {
                return 0;
            }
        });
        return words;
    }

    public static int countDistinctCharacters(String word) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : word.toCharArray()) {
            uniqueChars.add(c);
        }
        return uniqueChars.size();
    }
}
