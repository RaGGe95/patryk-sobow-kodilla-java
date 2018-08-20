package com.kodilla.stream.part7_4.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity(){
        //Given
        Country poland = new Country(new BigDecimal(40_000_000));
        Country german = new Country(new BigDecimal(30_000_000));
        Country france = new Country(new BigDecimal(30_000_000));
        Country unitedKingdom = new Country(new BigDecimal(30_000_000));
        Country netherlands = new Country(new BigDecimal(20_000_000));

        Country egypt = new Country(new BigDecimal(100_000_000));

        Continent europe = new Continent(poland, german, france, unitedKingdom, netherlands);
        Continent africa = new Continent(egypt);

        World world = new World(europe, africa);

        //When
        BigDecimal result = world.getPeopleQuantity();

        //Then
        Assert.assertEquals(new BigDecimal(250_000_000), result);
    }
}
