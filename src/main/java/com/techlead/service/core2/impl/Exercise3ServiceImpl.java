package com.techlead.service.core2.impl;

import com.techlead.service.core2.Exercise3Service;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class Exercise3ServiceImpl implements Exercise3Service {
    private final HashMap<String, Integer> persons = new HashMap<>();

    @Override
    public String addPerson(String name, int i) {
        persons.put(name, i);
        return "Added person"+name;
    }

    @Override
    public String displaySet() {
        return persons.toString();
    }

    @Override
    public int findAgeByName(String name) {
        return persons.containsKey(name) ? persons.get(name) : null;
    }

    @Override
    public String removePerson(String name) {
        if (persons.containsKey(name)) {
            return "removed";
        }
        return "Cannot found";
    }

    @Override
    public boolean checkExist(String name) {
        return persons.containsKey(name) ? true : false;
    }
}
