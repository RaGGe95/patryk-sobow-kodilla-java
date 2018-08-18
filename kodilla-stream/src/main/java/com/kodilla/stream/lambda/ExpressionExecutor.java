package com.kodilla.stream.lambda;

public class ExpressionExecutor {
    public void executeExpressionAndShowResult(double a, double b, MathExpression mathExpression) {
        double result = mathExpression.calculateExpression(a, b);
        System.out.println("Result equals: " + result);
    }

    public void calculateExampleExpression(){

        this.executeExpressionAndShowResult(10, 5, (a, b) -> a + b);
        this.executeExpressionAndShowResult(10, 5, (a, b) -> a - b);
        this.executeExpressionAndShowResult(10, 5, (a, b) -> a * b);
        this.executeExpressionAndShowResult(10, 5, (a, b) -> a / b);
    }

}