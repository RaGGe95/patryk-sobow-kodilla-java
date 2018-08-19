package com.kodilla.stream.part7_1.lambda;

public class ExpressionExecutor {
    public void executeExpressionAndShowResult(double a, double b, MathExpression mathExpression) {
        double result = mathExpression.calculateExpression(a, b);
        System.out.println("Result equals: " + result);
    }
}