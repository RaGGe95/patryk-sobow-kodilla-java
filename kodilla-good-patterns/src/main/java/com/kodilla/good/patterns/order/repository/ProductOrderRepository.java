package com.kodilla.good.patterns.order.repository;

import com.kodilla.good.patterns.order.model.Order;
import com.kodilla.good.patterns.order.model.User;

import java.util.List;

public class ProductOrderRepository implements OrderRepository {
    @Override
    public void createPurchase(User user, List<Order> order) {
        System.out.println("Creating a purchase for: " + user.toString() );
    }
}
