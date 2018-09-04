package com.kodilla.good.patterns.orderService;

import java.util.List;

public class ProductOrderRepository implements OrderRepository {
    @Override
    public void createPurchase(User user, List<Order> order) {
        System.out.println("Creating a purchase for: " + user.toString() );
    }
}
