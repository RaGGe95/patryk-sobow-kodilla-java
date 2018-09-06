package com.kodilla.good.patterns.rental.repository;

import com.kodilla.good.patterns.rental.model.User;

import java.time.LocalDateTime;

public interface RentalRepository {
    void createRental(User user, LocalDateTime from, LocalDateTime to);
}
