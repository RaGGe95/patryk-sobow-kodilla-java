package com.kodilla.patterns2.decorator.taxiportal.vipUtilities;

import com.kodilla.patterns2.decorator.taxiportal.AbstractTaxiOrderDecorator;
import com.kodilla.patterns2.decorator.taxiportal.TaxiOrder;

import java.math.BigDecimal;

public class TankAmmunitionDecorator extends AbstractTaxiOrderDecorator {
    public TankAmmunitionDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2000));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Tank Ammo";
    }
}
