package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductProvidersConfiguration {
    public static List<ProductProvider> buildProductProviders() {
        return new ArrayList<>(Arrays.asList(new HealthyShop(), new ExtraShop()));
    }
}
