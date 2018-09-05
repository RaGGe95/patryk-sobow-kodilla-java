package com.kodilla.good.patterns.food2door;

import java.util.List;

public class Application {
    public static void main(String... args) {
        final OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        final OrderRequest orderRequest = orderRequestRetriever.retrieve();

        final List<ProductProvider> productProviders = ProductProvidersConfiguration.buildProductProviders();

        final OrderProcessor orderProcessor = new OrderProcessor(productProviders);
        orderProcessor.orderProducts(orderRequest);
    }
}
