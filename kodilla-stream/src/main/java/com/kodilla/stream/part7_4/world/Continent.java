package com.kodilla.stream.part7_4.world;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Continent {
    private final List<Country> listCountry = new ArrayList<>();

    public Continent(Country... country) {
        listCountry.addAll(Arrays.asList(country));
    }

    public List<Country> getListCountry() {
        return new ArrayList<>(listCountry);
    }
}
