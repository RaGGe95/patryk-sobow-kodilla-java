package com.kodilla.patterns2.facade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

    @Autowired
    private ProductService productService;
    @Autowired
    private Authenticator authenticator;

    private final List<Order> orders = new ArrayList<>();


    public List<Order> getOrders() {
        return orders;
    }
}
