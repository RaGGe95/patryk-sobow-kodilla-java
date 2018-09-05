package com.kodilla.good.patterns.order;


import com.kodilla.good.patterns.order.dto.OrderDto;
import com.kodilla.good.patterns.order.model.OrderRequest;
import com.kodilla.good.patterns.order.repository.ProductOrderRepository;
import com.kodilla.good.patterns.order.serivce.MailService;
import com.kodilla.good.patterns.order.serivce.OrderProcessor;
import com.kodilla.good.patterns.order.serivce.OrderRequestRetriever;
import com.kodilla.good.patterns.order.serivce.ProductOrderService;

public class Application {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(
                new MailService(), new ProductOrderService(), new ProductOrderRepository());

        OrderDto orderDto = orderProcessor.process(orderRequest);
    }
}
