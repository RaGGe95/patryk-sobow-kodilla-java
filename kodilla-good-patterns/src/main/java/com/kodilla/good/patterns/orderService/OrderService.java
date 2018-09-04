package com.kodilla.good.patterns.orderService;

import java.util.List;

public interface OrderService {
    boolean checkIfPossibleToBuy(User user, List<Order> order);
}
