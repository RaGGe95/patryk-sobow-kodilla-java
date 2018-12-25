package com.kodilla.patterns2.facade;

import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@RequiredArgsConstructor
public class ShopSeviceWithLombokTest {

    private final ShopSeviceWithLombok shopSeviceWithLombok;

    @Test
    public void shopLombokTest(){

        System.out.println(shopSeviceWithLombok.getOrders().getClass().getSimpleName());
    }

}