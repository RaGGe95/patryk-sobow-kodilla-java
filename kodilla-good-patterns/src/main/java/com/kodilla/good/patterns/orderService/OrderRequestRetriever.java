package com.kodilla.good.patterns.orderService;

public class OrderRequestRetriever {

    public OrderRequest retrieve(){
        User user = new User("Patryk","Sobow");

        Order order1 = new Order("Kilogram prądu");
        Order order2 = new Order("Wiadro napięcia");

        return new OrderRequest(user,order1,order2);
    }
}
