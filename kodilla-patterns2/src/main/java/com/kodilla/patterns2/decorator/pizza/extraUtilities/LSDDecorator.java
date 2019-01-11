package com.kodilla.patterns2.decorator.pizza.extraUtilities;

import com.kodilla.patterns2.decorator.pizza.AbstractPizzaOrderDecorator;
import com.kodilla.patterns2.decorator.pizza.PizzaOrder;

import java.math.BigDecimal;

public class LSDDecorator extends AbstractPizzaOrderDecorator {
    public LSDDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(200));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + 5g LSD";
    }
}
