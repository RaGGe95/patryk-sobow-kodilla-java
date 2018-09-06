package com.kodilla.good.patterns.rental.service;

import com.kodilla.good.patterns.rental.model.User;

import java.time.LocalDateTime;

public class CarRentalService implements RentalService {

    @Override
    public  boolean rent(final User user, final LocalDateTime carRentFrom, final LocalDateTime carRentTo) {
        System.out.println("Renting car for: " + user.getName() + user.getSurname()
                    + " from " + carRentFrom.toString() + " to " + carRentTo.toString());

        return true;
    }
}
