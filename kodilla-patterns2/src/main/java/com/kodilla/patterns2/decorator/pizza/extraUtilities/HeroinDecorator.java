package com.kodilla.patterns2.decorator.pizza.extraUtilities;

import com.kodilla.patterns2.decorator.pizza.AbstractPizzaOrderDecorator;
import com.kodilla.patterns2.decorator.pizza.PizzaOrder;

import java.math.BigDecimal;

public class HeroinDecorator extends AbstractPizzaOrderDecorator {
    public HeroinDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(500));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + 5g Heroin";
    }
}
