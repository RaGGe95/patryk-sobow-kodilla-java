package com.kodilla.stream.part7_5.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {

            IntStream.range(0,numbers.length )
                .map(index -> numbers[index])
                .forEach(value -> System.out.print( value + ", " ));

            return IntStream.range(0,numbers.length )
                    .map(index -> numbers[index])
                    .average().getAsDouble();
    }
}
