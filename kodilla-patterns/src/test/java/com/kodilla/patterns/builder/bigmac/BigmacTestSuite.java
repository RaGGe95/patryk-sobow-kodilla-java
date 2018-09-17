package com.kodilla.patterns.builder.bigmac;

import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilder(){
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("Thin")
                .burgers(1)
                .ingredient("cheese")
                .sauce("Spicy")
                .ingredient("rabbit food")
                .build();
        System.out.println(bigmac);

    }
}


