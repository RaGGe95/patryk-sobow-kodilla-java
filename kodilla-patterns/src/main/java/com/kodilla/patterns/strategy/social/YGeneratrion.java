package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;

public class YGeneratrion extends User{
    public YGeneratrion(String name) {
        super(name);
        this.socialPublisher = new FacebookPublisher();
    }
}
