package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void getInstance() {
        Logger.getInstance();
    }

    @Test
    public void getLastLogTest(){
        //Given

        //When
        Logger.getInstance().log("Tymbark jabłko mięta BEZ KONSERWANTÓW");
        String result = Logger.getInstance().getLastLog();

        //Then
        Assert.assertEquals("Tymbark jabłko mięta BEZ KONSERWANTÓW", result);
    }
}
