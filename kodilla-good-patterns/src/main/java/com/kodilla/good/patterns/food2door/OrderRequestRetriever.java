package com.kodilla.good.patterns.food2door;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        final Product product1 = new ExtraProduct("Gwoździe", 1);
        final Product product2 = new HealthyProduct("Mąka", 2);

        return new OrderRequest(product1, product2);
    }
}
