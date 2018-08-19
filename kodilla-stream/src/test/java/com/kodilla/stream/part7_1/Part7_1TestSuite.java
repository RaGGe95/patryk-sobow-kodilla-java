package com.kodilla.stream.part7_1;

import com.kodilla.stream.part7_1.beautifier.PoemBeautifier;
import com.kodilla.stream.part7_1.beautifier.PoemDecorator;
import com.kodilla.stream.part7_1.lambda.Executor;
import com.kodilla.stream.part7_1.lambda.ExpressionExecutor;
import com.kodilla.stream.part7_1.lambda.Processor;
import com.kodilla.stream.part7_1.reference.FunctionalCalculator;
import org.junit.Test;

public class Part7_1TestSuite {

    @Test
    public void exampleProcessor() {
        Processor processor = new Processor();
        Executor codeToExecute = () -> System.out.println("This is an example text.");
        processor.execute(codeToExecute);
    }
    /*
W linii 8 tworzony jest obiekt klasy Processor, który odpowiedzialny jest za wykonywanie kodu, który zostanie przekazany jako parametr (kod musi implementować interfejs Executor)
W linii 9 tworzone jest wyrażenie lambda i przypisywane do zmiennej codeToExecute
W linii 10 wywoływana jest metoda execute klasy Processor, która jako argument otrzymuje wyrażenie lambda codeToExecute
     */


    @Test
    public void exampleExpressionExecutorWithLambda(){
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpressionAndShowResult(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpressionAndShowResult(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpressionAndShowResult(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpressionAndShowResult(10, 5, (a, b) -> a / b);
    }

    @Test
    public void exampleExpressionExecutorWithMethodReferences() {

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpressionAndShowResult(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpressionAndShowResult(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpressionAndShowResult(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpressionAndShowResult(3, 4, FunctionalCalculator::divideAByB);
    }

    @Test
    public void exampleBeautifier() {
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
    }
}
