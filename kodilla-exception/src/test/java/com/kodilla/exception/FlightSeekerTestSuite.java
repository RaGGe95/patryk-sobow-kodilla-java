package com.kodilla.exception;

import com.kodilla.exception.test.Airport;
import com.kodilla.exception.test.FlightSeeker;
import com.kodilla.exception.test.RouteNotFoundException;
import org.junit.Assert;
import org.junit.Test;

public class FlightSeekerTestSuite {

    @Test
    public void flightSeekerSuccess(){

        //Given
        Airport warsaw = new Airport("Warszawa");
        Airport berlin = new Airport("Berlin");
        Airport london = new Airport("Londyn");
        Airport paris = new Airport("Paryz");
        Airport egypt = new Airport("Egipt");
        Airport moscow = new Airport("Moskwa");
        Airport tokyo = new Airport("Tokio");
        Airport newYork = new Airport("Nowy York");

        /*
        Warszawa -> Berlin, Lodyn, Paryż
        Berlin -> Warszawa, Eigpt, Moskwa
        Moskwa -> Berlin, Tokio
        Tokio -> Moskwa, Nowy York
         */

        warsaw.addConnections(berlin,london,paris);
        berlin.addConnections(warsaw,egypt,moscow);
        moscow.addConnections(berlin,tokyo);
        tokyo.addConnections(moscow, newYork);

        //When
        FlightSeeker flightSeeker = new FlightSeeker();
        boolean result = false;
        try {
            result = flightSeeker.isFlightPossible(warsaw, newYork);
        } catch (RouteNotFoundException e) {
        }

        //Then
        Assert.assertEquals(true, result);

    }

    @Test
    public void flightSeekerFail(){

        //Given
        Airport warsaw = new Airport("Warszawa");
        Airport berlin = new Airport("Berlin");
        Airport london = new Airport("Londyn");
        Airport paris = new Airport("Paryz");
        Airport egypt = new Airport("Egipt");
        Airport moscow = new Airport("Moskwa");
        Airport tokyo = new Airport("Tokio");
        Airport newYork = new Airport("Nowy York");

        Airport zimbabwe = new Airport("Zimbabwe");

        /*
        Warszawa -> Berlin, Lodyn, Paryż
        Berlin -> Warszawa, Eigpt, Moskwa
        Moskwa -> Berlin, Tokio
        Tokio -> Moskwa, Nowy York
         */

        warsaw.addConnections(berlin,london,paris);
        berlin.addConnections(warsaw,egypt,moscow);
        moscow.addConnections(berlin,tokyo);
        tokyo.addConnections(moscow, newYork);

        //When
        FlightSeeker flightSeeker = new FlightSeeker();
        boolean result = true;
        try {
            result = flightSeeker.isFlightPossible(warsaw, zimbabwe);
        } catch (RouteNotFoundException e) {
        }

        //Then
        Assert.assertEquals(false, result);
    }
}
