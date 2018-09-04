package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderRequest {
    private List<Product> productList = new ArrayList<>();

    public OrderRequest(Product... products) {
        this.productList.addAll(Arrays.asList(products));
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "productList=" + productList +
                '}';
    }
}
