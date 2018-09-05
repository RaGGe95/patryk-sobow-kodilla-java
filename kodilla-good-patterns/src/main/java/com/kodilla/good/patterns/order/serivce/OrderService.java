package com.kodilla.good.patterns.order.serivce;

import com.kodilla.good.patterns.order.model.Order;
import com.kodilla.good.patterns.order.model.User;

import java.util.List;

public interface OrderService {
    boolean checkIfPossibleToBuy(User user, List<Order> order);
}
