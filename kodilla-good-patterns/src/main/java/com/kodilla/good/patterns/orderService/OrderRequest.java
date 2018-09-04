package com.kodilla.good.patterns.orderService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderRequest {
    private User user;
    private List<Order> listOrder = new ArrayList<>();

    public OrderRequest(User user, Order... order) {
        this.user = user;
        this.listOrder.addAll(Arrays.asList(order));
    }

    public User getUser() {
        return user;
    }

    public List<Order> getListOrder() {
        return listOrder;
    }
}
