package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;


public class StreamMain {
    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        /*
        Obiekt klasy ExpressionExecutor posiada metode executeExpression która jako parametr
        przyjmuje: liczbe, liczbe, oraz obiekt typu interfejsu MathExpression.
        W miejsce tego ostatniego obiektu można wstawić lambde.
         */

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("\nBeautifying strings\n");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautifyAndShow("Welcome", (string -> string + " Patryk"));
        poemBeautifier.beautifyAndShow("Welcome", (string -> "Patryk " + string));
        poemBeautifier.beautifyAndShow("Welcome", (string ->  string.toUpperCase() + " Patryk"));
        poemBeautifier.beautifyAndShow("Welcome", (string ->  (string + " Patryk").toUpperCase() ));

        PoemDecorator reverseString = (string) -> {
            String temp = "";
            for (int i = string.length()-1; i >= 0 ; i--) {
                temp = temp + string.substring(i, i+1);
            }
            return temp;
        };

        poemBeautifier.beautifyAndShow("Welcome", reverseString);
        //poemBeautifier.beautifyAndShow("Welcome", reverseString.toUpperCase());
    }
}