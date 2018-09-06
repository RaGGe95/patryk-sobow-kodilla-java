package com.kodilla.good.patterns.rental.service;

import com.kodilla.good.patterns.rental.model.User;

import java.time.LocalDateTime;

public interface RentalService {
    boolean rent(User user, LocalDateTime from, LocalDateTime to);
}
