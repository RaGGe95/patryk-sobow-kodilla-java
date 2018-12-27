package com.kodilla.patterns2.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ProductService productService;
    private final Authenticator authenticator;

    private final List<Order> orders = new ArrayList<>();


    public Long openOrder(Long userId){
        if (authenticator.isAuthenticated(userId)){
            Long maxOrder = (Long)orders.stream()
                    .mapToLong(order -> order.getOrderId())
                    .max().orElse(0);
            orders.add(new Order(maxOrder+1, userId, productService));
            return maxOrder + 1;
        } else {
            return -1L;
        }
    }

    public void addItem(Long orderId, Long productId, Double qty) {
        orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .forEach(o -> o.getItems().add(new Item(productId, qty)));
    }

    public Boolean removeItem(Long orderId, Long productId){
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        // ten stream zwraca iterator znajdujący się przed obiektem Order o polu id równym orderId?
        // ile obiektów ma w sobie teraz ten iterator ? jak to z nim jest ?
        // w Cpp iterator działa tak jak wskaźnik czyli wskazuje na konkretny element kolekcji
        // w javie iterator działa troche jak króliczek ? i on przeskakuje obiekty ? albo jest przed albo za ?

        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            int orderSize = theOrder.getItems().size();
            for (int i = 0; i < orderSize; i++){
                if(theOrder.getItems().get(i).getProductId().equals(productId)){
                    theOrder.getItems().remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public BigDecimal calculateValue(Long orderId){
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            return theOrder.calculateValue();
        }
        return BigDecimal.ZERO;
    }

    public Boolean doPayment (Long orderId){
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()){
            Order theOrder = orderIterator.next();
            if (theOrder.getPaid()){
                return true;
            } else {
                Random generator = new Random();
                theOrder.setPaid(generator.nextBoolean());
                return theOrder.getPaid();
            }
        }
        return false;
    }

    public boolean verifyOrder(Long orderId){
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            Boolean result = theOrder.getPaid();
            Random generator = new Random();
            if (!theOrder.getVerified()) {
                theOrder.setVerified(result && generator.nextBoolean());
            }
            return theOrder.getVerified();
        }
        return false;
    }

    public Boolean submitOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            if (theOrder.getVerified()){
                theOrder.setSubmitted(true);
            }
            return theOrder.getSubmitted();
        }
        return false;
    }

    public void cancelOrder(Long orderId){
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            orders.remove(theOrder);
        }
    }



}
