package com.kodilla.exception.recursion;



        /* to jest drzewo
        Warszawa -> Berlin, Paryż, Lodyn
        Berlin -> Eigpt, Moskwa
        Moskwa -> Tokio
        Tokio -> Nowy York
         */


public class FlightSeeker {
    private boolean searchResult = false;

    public FlightSeeker() {}


    // Łatwiejszy algorytm. dla drzewa.
    public boolean isFlightPossibleForTreeStructure(Airport start, Airport finish) {
        searchResult = false;

        if (start.getConnections().contains(finish)) {
            searchResult = true;
            return searchResult;
        }

        for (Airport each : start.getConnections()) {
            if (searchResult) break;

            if (each.getConnections().size() != 0) {
                isFlightPossibleForTreeStructure(each, finish);
            }
        }
        return searchResult;
    }




     /* to jest graf (tu są powtórzenia)
        Warszawa -> Berlin, Paryż, Lodyn
        Berlin -> Warszawa, Eigpt, Moskwa
        Moskwa -> Berlin, Tokio
        Tokio -> Moskwa, Nowy York


        // Algorytm w którym musimy wyeliminować nieskońćzone pętle
    // Berlin, newyork
        public boolean isFlightPossibleForGraphStructure(Airport start, Airport finish) throws RouteNotFoundException {

            if (set.contains(finish)) {
                set.clear();
                return true; // znaleźliśmy nasze docelowe lotnisko gdzieś przed końcem drzewa!
            }


            Iterator<Airport> iter = start.getConnections().iterator();

            while (iter.hasNext()) {

                Airport currentAirport = iter.next();

                if( set.contains(currentAirport) )
                    continue;


                set.add(currentAirport);



                if (  currentAirport.getConnections().size() != 0   ) {
                    isFlightPossibleForGraphStructure(currentAirport, finish);
                }

            }



            if (! set.contains(finish)) {
                set.clear();
                throw new RouteNotFoundException("Airport has not been found. ");
            } else {
                set.clear();
                return true;
            }
        }
*/

}
