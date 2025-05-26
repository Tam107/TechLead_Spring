package com.techlead.service.core2.impl;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Exercise9And10Service {


    public String checkWordFrequency(String text, HashMap<String, Integer> wordFrequency) {
        String[] words = text.toLowerCase()
                .replaceAll("[^a-zA-Z0-9\\s]", "")
                .split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        StringBuilder result = new StringBuilder();
        if (wordFrequency.isEmpty()) {
            result.append("Không có từ hợp lệ để đếm!");
        } else {
            result.append("Số lần xuất hiện của các từ:\n");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                result.append(String.format("Từ '%s': %d lần%n", entry.getKey(), entry.getValue()));
            }
        }

        return result.toString();
    }

    public Map<String, Integer> checkScore(Map<String, List<Double>> scores) {
        int highScore = 0, averageScore = 0, lowScore = 0;

        for (Map.Entry<String, List<Double>> entry : scores.entrySet()) {
            int sum = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
            }
            double avg = (double) sum / entry.getValue().size();
            if (avg >= 8.0) {
                highScore++;
            } else if (avg >= 5.0 && avg < 8.0) {
                averageScore++;
            } else {
                lowScore++;
            }
        }

        Map<String, Integer> result = new HashMap<>();
        result.put(">=8", highScore);
        result.put("<= 5 and < 8", averageScore);
        result.put("< 5", lowScore);

        return result;
    }

}
