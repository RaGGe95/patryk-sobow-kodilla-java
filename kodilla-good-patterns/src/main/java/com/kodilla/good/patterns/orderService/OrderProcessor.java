package com.kodilla.good.patterns.orderService;

import java.util.List;

public class OrderProcessor {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(final InformationService informationService,
                           final OrderService orderService,
                           final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(OrderRequest orderRequest) {

        User user = orderRequest.getUser();
        List<Order> orderList = orderRequest.getListOrder();


        boolean isPossibleToBuy = orderService.checkIfPossibleToBuy(user, orderList);
        if (isPossibleToBuy) {
            informationService.inform(user);
            orderRepository.createPurchase(user, orderList);
            return new OrderDto(user, true);
        } else {
            return new OrderDto(user,false );
        }
    }
}
