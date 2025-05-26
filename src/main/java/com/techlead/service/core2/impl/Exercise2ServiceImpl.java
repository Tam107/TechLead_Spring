package com.techlead.service.core2.impl;

import com.techlead.service.core2.Exercise2Service;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class Exercise2ServiceImpl implements Exercise2Service {

    private static final HashSet<String> set = new HashSet<>();
    @Override
    public String addCountries(String... str) {
        for (String countries : str) {
            set.add(countries);
        }
        return set.toString();
    }

    @Override
    public String displaySet() {
        return set.toString();
    }

    @Override
    public boolean checkExisting(String element) {
        for (String str : set) {
            if (str.toLowerCase().equals(element.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String removeElement(String element) {
        if (checkExisting(element)) {
            return set.toString();
        } else {
            return  "No element found";
        }
    }

    @Override
    public int calculation() {
        return set.size();
    }
}
