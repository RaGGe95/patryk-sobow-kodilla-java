package com.kodilla.good.patterns.food2door;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        Product product1 = new Product("Gwoździe", 1);
        Product product2 = new Product("Mąka", 2);

        return new OrderRequest(product1, product2);
    }
}
