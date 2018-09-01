package com.kodilla.exception.recursion;


import org.junit.Assert;
import org.junit.Test;

public class FlightSeekerTestSuite {

    @Test
    public void flightSeekerSuccessForTree(){

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

        /* TREE
        Warszawa -> Berlin, Lodyn, Paryż
        Berlin -> Eigpt, Moskwa
        Moskwa -> Tokio
        Tokio -> Nowy York
         */

        warsaw.addConnections(berlin,london,paris);
        berlin.addConnections(egypt,moscow);
        moscow.addConnections(tokyo);
        tokyo.addConnections(newYork);

        //When
        FlightSeeker flightSeeker = new FlightSeeker();
        boolean result = flightSeeker.isFlightPossibleForTreeStructure(warsaw, newYork);

        //Then
        Assert.assertEquals(true, result);
    }



    @Test
    public void flightSeekerFailForTree(){

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

        /* TREE
        Warszawa -> Berlin, Lodyn, Paryż
        Berlin -> Eigpt, Moskwa
        Moskwa -> Tokio
        Tokio -> Nowy York

        Zimbabwe
         */

        warsaw.addConnections(berlin,london,paris);
        berlin.addConnections(egypt,moscow);
        moscow.addConnections(tokyo);
        tokyo.addConnections(newYork);

        //When
        FlightSeeker flightSeeker = new FlightSeeker();
        boolean result = flightSeeker.isFlightPossibleForTreeStructure(warsaw, zimbabwe);


        //Then
        Assert.assertEquals(false, result);
    }

    @Test
    public void flightSeekerSuccessAndFailForTree(){

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

        /* TREE
        Warszawa -> Berlin, Lodyn, Paryż
        Berlin -> Eigpt, Moskwa
        Moskwa -> Tokio
        Tokio -> Nowy York

        Zimbabwe
         */

        warsaw.addConnections(berlin,london,paris);
        berlin.addConnections(egypt,moscow);
        moscow.addConnections(tokyo);
        tokyo.addConnections(newYork);

        //When
        FlightSeeker flightSeeker = new FlightSeeker();
        boolean result = flightSeeker.isFlightPossibleForTreeStructure(warsaw, newYork);
        boolean result2 = flightSeeker.isFlightPossibleForTreeStructure(warsaw, zimbabwe);
        boolean result3 = flightSeeker.isFlightPossibleForTreeStructure(berlin, tokyo);

        //Then
        Assert.assertEquals(true, result);
        Assert.assertEquals(false, result2);
        Assert.assertEquals(true, result3);
    }

}
