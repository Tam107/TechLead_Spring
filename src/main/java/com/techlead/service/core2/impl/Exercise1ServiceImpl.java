package com.techlead.service.core2.impl;

import com.techlead.service.core2.Exercise1Service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Exercise1ServiceImpl implements Exercise1Service {
    private final List<Integer> arrayList = new ArrayList<>();

    @Override
    public List<Integer> addElementToList(int element) {
        arrayList.add(element);
        return new ArrayList<>(arrayList);
    }

    @Override
    public List<Integer> displayElementsInList() {
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("ArrayList is empty");
        }
        return new ArrayList<>(arrayList);
    }

    @Override
    public List<Integer> removeElementFromList(int element) {
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("ArrayList is empty");
        }
        arrayList.remove(Integer.valueOf(element));
        return new ArrayList<>(arrayList);
    }

    @Override
    public int sumOfElementsInList() {
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("ArrayList is empty");
        }
        return arrayList.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public int maxElementInList() {
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("ArrayList is empty");
        }
        return arrayList.stream().max(Integer::compare).get();
    }

    @Override
    public int minElementInList() {
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("ArrayList is empty");
        }
        return arrayList.stream().min(Integer::compare).get();
    }

    @Override
    public boolean checkElementInList(int element) {
        return arrayList.contains(element);
    }
}
