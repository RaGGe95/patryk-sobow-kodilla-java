package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessor {
    private List<ProductProvider> productProviders;

    public OrderProcessor(List<ProductProvider> productProviders) {
        this.productProviders = productProviders;
    }

    public void orderProducts(OrderRequest orderRequest) {
        final List<Product> availableProducts = new ArrayList<>();

        for (ProductProvider productProvider : productProviders) {
            availableProducts.addAll(productProvider.process(orderRequest));
        }

        if (!availableProducts.containsAll(orderRequest.getProducts())) {
            throw new RuntimeException("Some products unavailable");
        }
    }
}
