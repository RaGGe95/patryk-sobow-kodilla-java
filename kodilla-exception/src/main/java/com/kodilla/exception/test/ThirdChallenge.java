package com.kodilla.exception.test;

public class ThirdChallenge {

    public static void main(String[] args) {
        FindingFlightClass findingFlightClass = new FindingFlightClass();
        Flight myFlight = null;

        try {
            findingFlightClass.isAirportAvailable(myFlight);
        } catch (RouteNotFoundException e) {
            System.out.println("Did not find airport but program still working. Exception: " + e);
        }

    }
}
