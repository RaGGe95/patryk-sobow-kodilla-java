package com.kodilla.patterns2.decorator.pizza.vipUtilities;

import com.kodilla.patterns2.decorator.pizza.AbstractPizzaOrderDecorator;
import com.kodilla.patterns2.decorator.pizza.PizzaOrder;

import java.math.BigDecimal;

public class DeliverByMilitaryTankDecorator extends AbstractPizzaOrderDecorator {
    public DeliverByMilitaryTankDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(20_000));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Deliver by military tank";
    }
}
