package com.kodilla.good.patterns.food2door.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface ProductProvider<T extends Product> {

    default List<T> process(OrderRequest orderRequest) {
        return orderRequest.getProducts().stream()
                .map(p -> {
                    try {
                        return (T) p;
                    } catch (ClassCastException ex) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}
