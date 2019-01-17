package com.kodilla.patterns2.decorator.pizza;


import static org.junit.Assert.*;

import com.kodilla.patterns2.decorator.pizza.basicUtilities.ChickenDecorator;
import com.kodilla.patterns2.decorator.pizza.basicUtilities.SalamiDecorator;
import com.kodilla.patterns2.decorator.pizza.extraUtilities.CocaineDecorator;
import com.kodilla.patterns2.decorator.pizza.extraUtilities.HeroinDecorator;
import com.kodilla.patterns2.decorator.pizza.extraUtilities.LSDDecorator;
import com.kodilla.patterns2.decorator.pizza.vipUtilities.DeliverByMilitaryTankDecorator;
import com.kodilla.patterns2.decorator.pizza.vipUtilities.DeliverBySpaceXFalconNineDecorator;
import org.junit.Test;

import java.math.BigDecimal;

public class PizzaTestSuite {
    @Test
    public void testBasicPizzaOrderGetCost(){
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        // When
        BigDecimal result = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(10), result);
    }

    @Test
    public void testBasicPizzaOrderGetDescription(){
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        // When
        String result = pizzaOrder.getDescription();

        // Then
        assertEquals("Dough + Cheese", result);
    }

    @Test
    public void testBasicPizzaWithChickenWithSalamiGetCost(){
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ChickenDecorator(pizzaOrder);
        pizzaOrder = new SalamiDecorator(pizzaOrder);

        // When
        BigDecimal result = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(20), result);
    }

    @Test
    public void testBasicPizzaWithChickenWithSalamiGetDescription(){
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ChickenDecorator(pizzaOrder);
        pizzaOrder = new SalamiDecorator(pizzaOrder);

        // When
        String result = pizzaOrder.getDescription();

        // Then
        assertEquals("Dough + Cheese + Chicken + Salami", result);
    }

    @Test
    public void testBasicPizzaWithCocaineWithHeroinWithLSDGetCost(){
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new CocaineDecorator(pizzaOrder);
        pizzaOrder = new HeroinDecorator(pizzaOrder);
        pizzaOrder = new LSDDecorator(pizzaOrder);

        // When
        BigDecimal result = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(1_110), result);
    }

    @Test
    public void testBasicPizzaWithCocaineWithHeroinWithLSDGetDescription(){
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new CocaineDecorator(pizzaOrder);
        pizzaOrder = new HeroinDecorator(pizzaOrder);
        pizzaOrder = new LSDDecorator(pizzaOrder);

        // When
        String result = pizzaOrder.getDescription();

        // Then
        assertEquals("Dough + Cheese + 5g Cocaine + 5g Heroin + 5g LSD", result);
    }

    @Test
    public void testBasicPizzaDeliverWithTankGetCost(){
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder.getClass();

        System.out.print(PizzaOrder.class);

        pizzaOrder = new DeliverByMilitaryTankDecorator(pizzaOrder);

        // When
        BigDecimal result = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(20_010), result);
    }

    @Test
    public void testBasicPizzaDeliverWithTankGetDescription(){
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new DeliverByMilitaryTankDecorator(pizzaOrder);

        // When
        String result = pizzaOrder.getDescription();

        // Then
        assertEquals("Dough + Cheese Deliver by military tank", result);
    }

    @Test
    public void testBasicPizzaDeliverWithFalconNineGetCost(){
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new DeliverBySpaceXFalconNineDecorator(pizzaOrder);

        // When
        BigDecimal result = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(5_000_010), result);
    }

    @Test
    public void testBasicPizzaDeliverWithFalconNineGetDescription(){
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new DeliverBySpaceXFalconNineDecorator(pizzaOrder);

        // When
        String result = pizzaOrder.getDescription();

        // Then
        assertEquals("Dough + Cheese Deliver by SpaceX Falcon 9 rocket", result);
    }
}
