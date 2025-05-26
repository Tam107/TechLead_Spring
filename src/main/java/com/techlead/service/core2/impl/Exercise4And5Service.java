package com.techlead.service.core2.impl;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class Exercise4And5Service {

    // ex4
    public List<String> sort(List<String> arr){
        Collections.sort(arr);
        return arr;
    }

    // ex5
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i< arr.length;i++){
            int complement = target - arr[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[] {};
    }
}
