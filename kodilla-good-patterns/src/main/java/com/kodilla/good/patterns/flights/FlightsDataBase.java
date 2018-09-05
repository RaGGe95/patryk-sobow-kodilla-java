package com.kodilla.good.patterns.flights;

import java.util.*;

public class FlightsDataBase {

    private Map<Airport, List<Airport>> airportsMap = new HashMap<>();

    public Map<Airport, List<Airport>> retrieve(){

        Airport wroclaw = new Airport("Wrocław");
        Airport warsaw = new Airport("Warszawa");
        Airport poznan = new Airport("Poznań");
        Airport krakow = new Airport("Kraków");
        Airport gdansk = new Airport("Gdańsk");

        Airport berlin = new Airport("Berlin");
        Airport london = new Airport("Londyn");
        Airport paris = new Airport("Paryż");

        airportsMap.put(wroclaw,    Arrays.asList(warsaw, poznan, krakow, berlin));
        airportsMap.put(gdansk,     Arrays.asList(warsaw, poznan, krakow));
        airportsMap.put(krakow,     Arrays.asList(wroclaw, berlin));
        airportsMap.put(warsaw,     Arrays.asList(berlin, london));
        airportsMap.put(london,     Arrays.asList(paris));

        return airportsMap;
    }

    public Map<Airport, List<Airport>> getAirportsMap() {
        return airportsMap;
    }
}
