package com.kodilla.testing.shape;

public class Circle implements Shape {
    private final double radius;

    public Circle(double newRadius) {
        this.radius = newRadius;
    }

    @Override
    public double getField() {
        return Math.PI * radius * radius;
    }
}
