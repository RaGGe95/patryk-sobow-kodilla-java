package com.kodilla.good.patterns.orderService;

import java.util.List;

public class ProductOrderService implements OrderService {

    @Override
    public boolean checkIfPossibleToBuy(User user, List<Order> order) {
        System.out.println("Checking if possible to buy: " + order.toString() + " for " + user.toString());
        return true;
    }
}
