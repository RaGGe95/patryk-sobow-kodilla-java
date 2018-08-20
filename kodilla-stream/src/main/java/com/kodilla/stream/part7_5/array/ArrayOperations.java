package com.kodilla.stream.part7_5.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {

        System.out.print("Zawartosc tablicy: ");
        IntStream.range(0,numbers.length )
                .map(index -> numbers[index])
               //.map(value -> String.valueOf(value) - Tak nie można ponieważ używamy klasy IntStream, dlatego nie da się zmapować prymitywnego int na obiektowe String
                .forEach(value -> System.out.print( value + ", " ));

        return IntStream.range(0,numbers.length )
                .map(index -> numbers[index])
                .average().getAsDouble();
    }

    static double getAverageVersion2(int[] numbers) {

        System.out.print("Zawartosc tablicy: ");
        Arrays.stream(numbers)
                //.map(value -> String.valueOf(value)); - Tutaj też tak nie można
                .forEach(value -> System.out.print( value + ", " ));


        if (numbers.length != 0) {
            return IntStream.range(0, numbers.length)
                    .map(index -> numbers[index])
                    .average()
                    .getAsDouble();
        } else {
            return 0;
        }
    }

    static double getAverageVersion3(int[] numbers) {

        System.out.print("Zawartosc tablicy: ");
        Arrays.stream(numbers)
                //.map(value -> String.valueOf(value)); - Tutaj też tak nie można
                .forEach(value -> System.out.print( value + ", " ));


            return IntStream.range(0, numbers.length)
                    .map(index -> numbers[index])
                    .average()
                    .orElse(0);
    }
}
