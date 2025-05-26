package com.techlead.service.core2;

import java.util.List;

public interface Exercise1Service {

    List<Integer> addElementToList(int element);
    List<Integer> displayElementsInList();
    List<Integer> removeElementFromList(int element);
    int sumOfElementsInList();
    int maxElementInList();
    int minElementInList();
    boolean checkElementInList(int element);

}
