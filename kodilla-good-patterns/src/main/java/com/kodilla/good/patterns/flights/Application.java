package com.kodilla.good.patterns.flights;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        FlightsDataBase dataBase = new FlightsDataBase();
        Map<Airport, List<Airport>> airportsMap = dataBase.retrieve();
        FlightSeeker flightSeeker = new FlightSeeker(airportsMap);

        Airport wroclaw = new Airport("Wrocław");
        List<Airport> airportList = flightSeeker.findDirectConnectionsFrom(wroclaw);
        System.out.println("Lista bezpośrednich połączeń z Wrocławia: " + airportList);

        Airport berlin = new Airport("Berlin");
        airportList = flightSeeker.findDirectConnectionsTo(berlin);
        System.out.println("Lista bezpośrednich połączeń do Berlina: " + airportList);

        Airport krakow = new Airport("Kraków");
        Map<List<Airport>, List<Airport>> result = flightSeeker.findDirectConnectionsFromAndTo(krakow);

        System.out.print("Bezpośrednia połączenia z Krakowa: ");
        result.entrySet().stream()
                .map(entry -> entry.getKey())
                .flatMap(list -> list.stream())
                .forEach(airports -> System.out.print(airports + ", "));

        System.out.print("\nBezpośrednia połączenia do Krakowa: ");
        result.entrySet().stream()
                .map(entry -> entry.getValue())
                .flatMap(list -> list.stream())
                .forEach(airports -> System.out.print(airports + ", "));


    }
}
