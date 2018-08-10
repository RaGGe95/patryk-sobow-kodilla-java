package com.kodilla.testing.shape;

public class EquilateralTriangle implements  Shape{
    private final double sideLength;

    public EquilateralTriangle(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getField() {
        return sideLength * sideLength * Math.sqrt(3) / 4.0 ;
    }
}
