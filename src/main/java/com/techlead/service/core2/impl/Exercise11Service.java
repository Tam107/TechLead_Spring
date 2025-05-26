package com.techlead.service.core2.impl;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Exercise11Service {

    private final Map<String, String> dictionary = new HashMap<>();

    public String searchWord(String word) {
        return dictionary.get(word);
    }

    public String addWord(String word, String meaning) {
        if (dictionary.containsKey(word)) {
            throw new IllegalArgumentException("Word already exists in the dictionary.");
        }
        dictionary.put(word, meaning);
        return "Added word "+word+" meaning: "+meaning;
    }
}
