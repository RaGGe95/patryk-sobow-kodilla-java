package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FindingFlightClass {

    public boolean isAirportAvailable(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> flightMap = new HashMap<>();

        flightMap.put("Lotnisko 1", true);
        flightMap.put("Lotnisko 2", false);
        flightMap.put("Lotnisko 3", true);

        try {
            flightMap.containsKey(flight.getArrivalAirport());
        } catch (NullPointerException e) {
            throw new RouteNotFoundException("Flight was null");
        }

        return flightMap.containsKey(flight.getArrivalAirport());
    }


}
