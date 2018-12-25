package com.kodilla.patterns2.facade;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceTest {

    @Autowired
    ShopService shopService;

    @Test
    public void shopLombokTest(){

        System.out.println(shopService.getOrders().getClass().getSimpleName());
    }

}