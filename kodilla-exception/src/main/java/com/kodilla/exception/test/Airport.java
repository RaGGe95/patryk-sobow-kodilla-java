package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Airport {

    private final String name;
    private List<Airport> connections = new ArrayList<>();

    public Airport(String name)
    {
        this.name = name;
    }

    public void addConnections(Airport... Table) {
        connections.addAll(Arrays.asList(Table));
    }

    public List<Airport> getConnections() {
        return connections;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        return getName().equals(airport.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
