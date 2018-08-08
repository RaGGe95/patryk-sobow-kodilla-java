package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){
        final int a = 2, b = 2;
        Calculator myCalculator = new Calculator();

        int result = myCalculator.add(a, b);

        if (result == (a+b) ) {
            System.out.println("Test dodawania poprawny");
        }
        else System.out.println("Test dodawania niepoprawny");

        result = myCalculator.subtract(a, b);

        if (result == (a-b) ) {
            System.out.println("Test odejmowania poprawny");
        }
        else System.out.println("Test odejmowania niepoprawny");


    }
}
