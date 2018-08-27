package com.kodilla.exception.test;



public class FlightSeeker {
    public FlightSeeker() {}

    public boolean isFlightPossible(Airport start, Airport finish) throws RouteNotFoundException {

        // Załóżmy że mamy dowolną ilość lotnisk oraz połączeń.

        //Najefektywniejszym sposobem będzie rekurencja, ale nie umiem.

        //można by wykorzystać Set żeby wrzucić do niego wszystkie unikalne połączenia
        // i jeżeli znajdzie się w nim szukane lotnisko to zwracamy true
        // a jeżeli nie to wyrzycamy RouteNotFoundException

        //co do streamów to nie wiem jak poradzić sobie z tym że nie wiem od początku ile razy trzeba będzie użyć .flatMap

        /*
        Warszawa -> Berlin, Paryż, Lodyn
        Berlin -> Warszawa, Eigpt, Moskwa
        Moskwa -> Berlin, Tokio
        Pekin -> Moskwa, Nowy York

        Londyn -> Warszawa, Nowy York
         */


        return false;
    }


}
