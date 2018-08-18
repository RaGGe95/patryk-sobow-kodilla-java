package com.kodilla.stream.world;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Continent {
    private List<Country> listCountry = new ArrayList<>();

    public Continent(Country... country) {
        listCountry.addAll(Arrays.asList(country));
    }

    public List<Country> getListCountry() {
        return new ArrayList<>(listCountry);
    }
}
