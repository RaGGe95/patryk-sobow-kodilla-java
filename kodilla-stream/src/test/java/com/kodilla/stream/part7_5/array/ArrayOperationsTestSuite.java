package com.kodilla.stream.part7_5.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){
        //Given
        int[] testArray = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //When
        double result = ArrayOperations.getAverage(testArray);

        long sum = Arrays.stream(testArray)
                .sum();

        System.out.println("\nSuma liczb w tablicy = " + sum + "\nRozmiar tablicy = " + testArray.length);

        //Then
        Assert.assertEquals(4.5, result, 0);
    }

    @Test
    public void testGetAverageVersion2EmptyArray(){
        //Given
        int[] testEmptyArray = new int[] {};
        //When
        double result = ArrayOperations.getAverageVersion2(testEmptyArray);

        long sum = Arrays.stream(testEmptyArray)
                .sum();

        System.out.println("\nSuma liczb w tablicy = " + sum + "\nRozmiar tablicy = " + testEmptyArray.length);

        //Then
        Assert.assertEquals(0, result, 0);
    }


    @Test
    public void exampleStaticArrayStream(){
        //Given
        int[] testArray = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Arrays.stream(testArray)
                .forEach(System.out::println);
    }
}
