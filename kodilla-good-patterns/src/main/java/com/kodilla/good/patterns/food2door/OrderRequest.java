package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderRequest {

    private List<Product> products = new ArrayList<>();

    public OrderRequest(Product... products) {
        this.products.addAll(Arrays.asList(products));
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "products=" + products +
                '}';
    }
}
