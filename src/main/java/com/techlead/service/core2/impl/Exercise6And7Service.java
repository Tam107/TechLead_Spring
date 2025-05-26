package com.techlead.service.core2.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Exercise6And7Service {

    private static final HashMap<Integer, Integer> map = new HashMap<>();


    public int[] twoSum(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }

    public String calculateStudentScore(HashMap<String, List<Double>> studentScores) {
        List<String> calculation = new ArrayList<>();
        for(Map.Entry<String, List<Double>> map : studentScores.entrySet()){
            String s = "Student: "+ map.getKey()+" average score: "+calculateAverage(map.getValue());
            calculation.add(s);
        }

        return calculation.toString();
    }

    private static double calculateAverage(List<Double> score){
        double total = 0;
        for (Double mark : score){
            total += mark;
        }
        return total / score.size();
    }
}
