package com.techlead.service.core2.impl;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Exercise13to18ServiceImpl {

    public Set<Integer> removeDuplicate(int[] arr) {
        Set<Integer> nums = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : arr) {
            if (nums.contains(num)) {
                duplicates.add(num);
            } else {
                nums.add(num);
            }
        }

        return duplicates;
    }

    public Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        return intersection;
    }

    public Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }

    public int[] findMaxAndMin(Set<Integer> set) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : set) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return new int[]{min, max};
    }

    public Set<String> removeDuplicate(Set<String> set) {
        return set;
    }

    public int countWords(Set<String> set) {
        return set.size();
    }
}
