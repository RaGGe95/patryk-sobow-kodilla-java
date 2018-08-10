package com.kodilla.testing.shape;

public class Square implements Shape{
    private final double sideLength;

    public Square(double newSideLength) {
        this.sideLength = newSideLength;
    }

    @Override
    public double getField() {
        return sideLength * sideLength;
    }
}
