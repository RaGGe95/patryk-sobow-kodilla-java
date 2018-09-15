package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";
    
    public final Task makeTask(final String taskClass) {
        switch (taskClass){
            case DRIVING:
                return new DrivingTask("Jedź po alkohol", "MONOPOLOWY-24H", "Taczka");
            case SHOPPING:
                return new ShoppingTask("Kup alkohol", "Finlandia 0.7L", 2);
            case PAINTING:
                return new PaintingTask("Pomaluj dom", "Ładny", "Dom");
            default:
                return null;
        }
    }
}
