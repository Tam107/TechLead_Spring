package com.techlead.service.core2;

import java.util.HashMap;

public interface Exercise3Service {

    String addPerson(String name, int i);

    String displaySet();

    int findAgeByName(String name);

    String removePerson(String name);

    boolean checkExist(String name);
}
