package com.kodilla.patterns2.decorator.taxiportal;

import com.kodilla.patterns2.decorator.taxiportal.additionalUtilities.ChildSeatDecorator;
import com.kodilla.patterns2.decorator.taxiportal.basicUtilities.TaxiNetworkOrderDecorator;
import com.kodilla.patterns2.decorator.taxiportal.vipUtilities.TankAmmunitionDecorator;
import com.kodilla.patterns2.decorator.taxiportal.vipUtilities.TankOrderDecorator;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class TaxiTestSuite {
    @Test
    public void testBasicTaxiOrderGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();

        // When
        BigDecimal result = theOrder.getCost();

        // Then
        assertEquals(new BigDecimal(5), result);
    }

    @Test
    public void testTaxiNetworkOrderGetCost(){
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);

        // When
        BigDecimal result = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal(40), result);
    }

    @Test
    public void testTaxiNetworkOrderGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);

        // When
        String result = theOrder.getDescription();

        // Then
        assertEquals("Drive a course by taxi", result);
    }

    @Test
    public void testTaxiNetworkOrderWithChildSeatGetCost(){
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        // When
        BigDecimal result = theOrder.getCost();

        // Then
        assertEquals(new BigDecimal(42), result);
    }

    @Test
    public void testTankOrderWithAmmoWithChildSeatGetCost(){
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TankOrderDecorator(theOrder);
        theOrder = new TankAmmunitionDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        // When
        BigDecimal result = theOrder.getCost();

        // Then
        assertEquals(new BigDecimal(7007), result);
    }

    @Test
    public void testTankOrderWithAmmoWithChildSeatGetDescription(){
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TankOrderDecorator(theOrder);
        theOrder = new TankAmmunitionDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        // When
        String result = theOrder.getDescription();

        // Then
        assertEquals("Drive a course by Tank + Tank Ammo + child seat", result);
    }
}
