package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    private String taskName;
    private String whatToBut;
    private double quantity;
    private boolean isExecuted = false;

    public ShoppingTask(String taskName, String whatToBut, double quantity) {
        this.taskName = taskName;
        this.whatToBut = whatToBut;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        if (!isExecuted) {
            isExecuted = true;
        } else {
            System.out.println("Already executed");
        }
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getWhatToBut() {
        return whatToBut;
    }

    public double getQuantity() {
        return quantity;
    }
}
