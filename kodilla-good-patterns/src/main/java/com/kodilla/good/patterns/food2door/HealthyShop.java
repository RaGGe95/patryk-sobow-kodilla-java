package com.kodilla.good.patterns.food2door;

public class HealthyShop implements ProductProvider {
    @Override
    public boolean process(OrderRequest orderRequest) {
        System.out.println("Processing orderRequest: " + orderRequest.toString());
        return true;
    }
}
