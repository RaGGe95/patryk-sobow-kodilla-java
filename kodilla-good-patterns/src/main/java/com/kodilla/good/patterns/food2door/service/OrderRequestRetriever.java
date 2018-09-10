package com.kodilla.good.patterns.food2door.service;

import com.kodilla.good.patterns.food2door.products.ExtraProduct;
import com.kodilla.good.patterns.food2door.products.HealthyProduct;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        final Product product1 = new ExtraProduct("Gwoździe", 1);
        final Product product2 = new HealthyProduct("Mąka", 2);

        return new OrderRequest(product1, product2);
    }
}
