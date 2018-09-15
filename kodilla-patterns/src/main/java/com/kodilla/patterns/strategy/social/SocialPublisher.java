package com.kodilla.patterns.strategy.social;

public interface SocialPublisher {
   default String share(){
       return this.getClass().getSimpleName();
   }
}
