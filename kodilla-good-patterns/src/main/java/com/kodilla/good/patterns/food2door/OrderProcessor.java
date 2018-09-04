package com.kodilla.good.patterns.food2door;

public class OrderProcessor {
    private ProductProvider productProvider;

    public OrderProcessor(ProductProvider productProvider) {
        this.productProvider = productProvider;
    }

    public boolean orderProducts(OrderRequest orderRequest){
        boolean isOrderPossible = productProvider.process(orderRequest);
        return isOrderPossible;
    }
}
