package com.kodilla.testing.shape;

public interface Shape {

    default String getShapeName() {
        return getClass().getSimpleName();
    }

    double getField();
}
