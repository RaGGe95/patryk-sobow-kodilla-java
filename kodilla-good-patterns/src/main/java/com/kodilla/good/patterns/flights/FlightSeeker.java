package com.kodilla.good.patterns.flights;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightSeeker {
    private final Map<Airport, List<Airport>> airportsMap;

    public FlightSeeker(Map<Airport, List<Airport>> airportsMap) {
        this.airportsMap = airportsMap;
    }

    //PYTANIE czy da się to jakoś prościej ? tzn. po linijce 18 odrazu zwrócić tą liste zamiast robić flatmap?
    public List<Airport> findDirectConnectionsFrom(Airport airport){
         return airportsMap.entrySet().stream()
                .filter(entry -> entry.getKey().equals(airport))
                .map(entry -> entry.getValue())
                .flatMap(airportsList -> airportsList.stream())
                .collect(Collectors.toList());
    }

    public List<Airport> findDirectConnectionsTo(Airport airport){
        return airportsMap.entrySet().stream()
                .filter(entry -> entry.getValue().contains(airport))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    public  Map<List<Airport>, List<Airport>> findDirectConnectionsFromAndTo(Airport airport) {

        Map<List<Airport>, List<Airport>> airportsMap = new HashMap<>();
        airportsMap.put(findDirectConnectionsFrom(airport), findDirectConnectionsTo(airport));

        return airportsMap;
    }
}
