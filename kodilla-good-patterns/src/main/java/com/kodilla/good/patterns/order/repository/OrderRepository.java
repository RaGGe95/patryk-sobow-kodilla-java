package com.kodilla.good.patterns.order.repository;

import com.kodilla.good.patterns.order.model.Order;
import com.kodilla.good.patterns.order.model.User;

import java.util.List;

public interface OrderRepository {
    void createPurchase(User user, List<Order> order);
}
