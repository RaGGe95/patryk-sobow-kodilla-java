package com.kodilla.good.patterns.flights;

import java.util.*;
import java.util.stream.Collectors;

public class FlightSeeker {
    private final Map<Airport, List<Airport>> airportsMap;
    private Set<Airport> resultSet = new HashSet<>();

    public FlightSeeker(Map<Airport, List<Airport>> airportsMap) {
        this.airportsMap = airportsMap;
    }


    public List<Airport> findDirectConnectionsFrom(Airport airport){
         return airportsMap.get(airport);
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

    //Znajduje każdy element w strukturze drzewa
    public Set<Airport> findEveryConnectionsFrom(Airport airport){
        if (airportsMap.get(airport) == null || airportsMap.get(airport).size() == 0) {
            return null;
        }


        for (Airport each : airportsMap.get(airport)) {
            resultSet.add(each);

            findEveryConnectionsFrom(each);
        }
        return resultSet;
    }


}
