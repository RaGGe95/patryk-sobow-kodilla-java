package com.kodilla.testing.shape;

import java.util.*;

public class ShapeCollector {
    private final List<Shape> listOfShapes = new ArrayList<>();

    public void addFigure(Shape shape){
        listOfShapes.add(shape);
    }

    public int getFiguresQuantity() {
        return listOfShapes.size();
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (listOfShapes.contains(shape)){
            listOfShapes.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int number){
        Shape theShape = null;
        if (number >= 0 && number < listOfShapes.size()) {
            theShape = listOfShapes.get(number);
        }
        return theShape;
    }

    public String showFigures() {
        String result = "";
        for (Shape each : listOfShapes){
            result += each.getShapeName() + "\n";
        }
        return result;
    }
}
