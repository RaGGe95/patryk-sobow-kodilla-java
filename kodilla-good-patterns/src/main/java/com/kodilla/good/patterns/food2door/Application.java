package com.kodilla.good.patterns.food2door;

public class Application {
    public static void main(String... args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(new HealthyShop());
        orderProcessor.orderProducts(orderRequest);
    }
}
