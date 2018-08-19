package com.kodilla.stream.part7_2;

import com.kodilla.stream.part7_2.iterate.NumbersGenerator;
import org.junit.Test;

public class Part7_2TestSuite {
    @Test
    public void exampleNumberGeneratorTest() {
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
