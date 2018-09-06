package com.kodilla.good.patterns.rental.service;

import com.kodilla.good.patterns.rental.dto.RentalDto;
import com.kodilla.good.patterns.rental.model.RentRequest;
import com.kodilla.good.patterns.rental.model.User;
import com.kodilla.good.patterns.rental.repository.RentalRepository;

import java.time.LocalDateTime;

public class RentalProcessor {

    private InformationService informationService;
    private RentalService rentalService;
    private RentalRepository rentalRepository;

    public RentalProcessor(final InformationService informationService,
                           final RentalService rentalService,
                           final RentalRepository rentalRepository) {
        this.informationService = informationService;
        this.rentalService = rentalService;
        this.rentalRepository = rentalRepository;
    }

    public RentalDto process(RentRequest rentRequest) {

        User user = rentRequest.getUser();
        LocalDateTime from = rentRequest.getFrom();
        LocalDateTime to = rentRequest.getTo();

        boolean isRented = rentalService.rent(user, from ,to);
        if (isRented) {
            informationService.inform(user);
            rentalRepository.createRental(user,from ,to);
            return new RentalDto(user, true);
        } else {
            return new RentalDto(user,false );
        }
    }
}
