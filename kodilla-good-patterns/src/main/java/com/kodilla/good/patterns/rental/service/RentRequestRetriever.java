package com.kodilla.good.patterns.rental.service;

import com.kodilla.good.patterns.rental.model.RentRequest;
import com.kodilla.good.patterns.rental.model.User;

import java.time.LocalDateTime;

public class RentRequestRetriever {

    public RentRequest retrieve(){
        User user = new User("Patryk","Sobow");

        LocalDateTime rentFrom = LocalDateTime.of(2017,8,1,12,0 );
        LocalDateTime rentTo = LocalDateTime.of(2017,8,10,12,0 );

        return new RentRequest(user, rentFrom, rentTo);
    }
}
