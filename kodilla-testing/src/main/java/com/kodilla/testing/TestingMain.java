package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){

        Calculator myCalculator = new Calculator();

        int resultAdd = myCalculator.add(2, 2);

        if (resultAdd == (4) ) {
            System.out.println("Test dodawania poprawny");
        } else {
            System.out.println("Test dodawania niepoprawny");
        }

        int resultSub = myCalculator.subtract(2, 2);

        if (resultSub == (0) ) {
            System.out.println("Test odejmowania poprawny");
        } else {
            System.out.println("Test odejmowania niepoprawny");
        }
    }
}
