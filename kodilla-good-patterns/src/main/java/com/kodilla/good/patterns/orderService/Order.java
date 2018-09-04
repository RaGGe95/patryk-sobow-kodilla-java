package com.kodilla.good.patterns.orderService;

public class Order {
    private String name;

    public Order(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Order{'" + name + "'}";
    }
}
