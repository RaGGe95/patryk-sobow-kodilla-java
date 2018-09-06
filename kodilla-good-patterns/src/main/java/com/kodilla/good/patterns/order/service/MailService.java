package com.kodilla.good.patterns.order.service;


import com.kodilla.good.patterns.order.model.User;

public class MailService implements InformationService {

    @Override
    public void inform(User user) {
        System.out.println("Sending information e-mail for user: " + user.toString());
    }
}
