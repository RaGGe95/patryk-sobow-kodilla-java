package com.kodilla.good.patterns.rentalservice;

import java.time.LocalDateTime;

public class CarRentalService implements RentalService {

    @Override
    public  boolean rent(final User user, final LocalDateTime carRentFrom, final LocalDateTime carRentTo) {
        System.out.println("Renting car for: " + user.getName() + user.getSurname()
                    + " from " + carRentFrom.toString() + " to " + carRentTo.toString());

        return true;
    }
}
