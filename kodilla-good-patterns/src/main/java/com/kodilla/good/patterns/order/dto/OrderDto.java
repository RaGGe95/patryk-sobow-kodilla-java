package com.kodilla.good.patterns.order.dto;

import com.kodilla.good.patterns.order.model.User;

public class OrderDto {
    private User user;
    private boolean isPossibleToBuy;

    public OrderDto(User user, boolean isPossibleToBuy) {
        this.user = user;
        this.isPossibleToBuy = isPossibleToBuy;
    }

    public User getUser() {
        return user;
    }

    public boolean isPossibleToBuy() {
        return isPossibleToBuy;
    }
}
