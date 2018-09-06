package com.kodilla.good.patterns.rental.model;

import java.time.LocalDateTime;

public class RentRequest {

    private User user;
    private LocalDateTime from;
    private LocalDateTime to;

    public RentRequest(User user, LocalDateTime from, LocalDateTime to) {
        this.user = user;
        this.from = from;
        this.to = to;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }
}
