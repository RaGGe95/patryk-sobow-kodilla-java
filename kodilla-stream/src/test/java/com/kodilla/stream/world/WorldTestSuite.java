package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity(){
        //Given
        Country poland = new Country(new BigDecimal("40000000")); // 40 mln
        Country german = new Country(new BigDecimal("30000000")); // 30 mln
        Country france = new Country(new BigDecimal("30000000")); // 30 mln
        Country unitedKingdom = new Country(new BigDecimal("30000000")); // 30 mln
        Country netherlands = new Country(new BigDecimal("20000000")); // 20 mln

        Country egypt = new Country(new BigDecimal("100000000")); // 100 mln

        Continent europe = new Continent(poland, german, france, unitedKingdom, netherlands);
        Continent africa = new Continent(egypt);

        World world = new World(europe, africa);

        //When
        BigDecimal result = world.getPeopleQuantity();

        //Then
        Assert.assertEquals(new BigDecimal("250000000"), result);
    }
}
