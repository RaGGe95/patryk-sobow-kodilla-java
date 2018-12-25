package com.kodilla.patterns2.facade;

public class Item {
    private final Long productId;
    private final Double quantity;

    public Item(Long productId, Double quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public Double getQuantity() {
        return quantity;
    }
}
