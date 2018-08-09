package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {

    // Funkcja usuwa liczby nieparzyste z listy, oraz modyfikuje argument.
    public List<Integer> exterminate(List<Integer> numbers) {
        numbers.removeIf(temp -> temp % 2 != 0);
        return numbers;
    }
}
