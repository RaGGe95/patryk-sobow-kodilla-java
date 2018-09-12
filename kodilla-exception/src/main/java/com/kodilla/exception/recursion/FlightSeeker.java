package com.kodilla.exception.recursion;



public class FlightSeeker {

    public FlightSeeker() {}


    // Łatwiejszy algorytm. dla drzewa.
    public boolean isFlightPossibleForTreeStructure(Airport start, Airport finish) {
        if (start.getConnections() == null || start.getConnections().size() == 0) {
            return false;
        }

        if (start.getConnections().contains(finish)) {
            return true;
        }

        for (Airport each : start.getConnections()) {
            if(isFlightPossibleForTreeStructure(each, finish)) {
                return true;
            }
        }
        return false;
    }



    /*  to jest drzewo
        Warszawa -> Berlin, Paryż, Lodyn
        Berlin -> Eigpt, Moskwa
        Moskwa -> Tokio
        Tokio -> Nowy York
        */

     /* to jest graf (tu są powtórzenia)
        Warszawa -> Berlin, Paryż, Lodyn
        Berlin -> Warszawa, Eigpt, Moskwa
        Moskwa -> Berlin, Tokio
        Tokio -> Moskwa, Nowy York
    */
}
