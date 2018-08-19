package com.kodilla.stream.part7_4.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class World {
    private final List<Continent> listOfContinent = new ArrayList<>(); // czy to musi być final??

    public World(Continent... continents){
        listOfContinent.addAll(Arrays.asList(continents));
    }

    public BigDecimal getPeopleQuantity() {
        return listOfContinent.stream()
                .flatMap(continent -> continent.getListCountry().stream() )
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
