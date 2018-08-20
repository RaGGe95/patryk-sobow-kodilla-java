package com.kodilla.stream.part7_5.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){

        /*
        Ten test nie przejdzie dla pustej tablicy!!
         */

        //Given
        //int[] testEmptyArray = new int[] {};
        int[] testArray = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        //When
       // System.out.println("Pusta tablica");
        //double resultEmpty = ArrayOperations.getAverage(testEmptyArray);

        System.out.println("\nWypelniona tablica ");
        double resultArray = ArrayOperations.getAverage(testArray);

        long sum = Arrays.stream(testArray)
                .sum();

        System.out.println("\nSuma liczb w tablicy = " + sum + "\nRozmiar tablicy = " + testArray.length);

        //Then
        // Assert.assertEquals(0, resultEmpty, 0);
        Assert.assertEquals(4.5, resultArray, 0);
    }

    @Test
    public void testGetAverageVersion2EmptyArray(){
        //Given
        int[] testEmptyArray = new int[] {};
        int[] testArray = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        //When
        System.out.println("Pusta tablica");
        double resultEmpty = ArrayOperations.getAverageVersion2(testEmptyArray);
        System.out.println("\nWypelniona tablica ");
        double resultArray = ArrayOperations.getAverageVersion2(testArray);

        long sum = Arrays.stream(testArray)
                .sum();

        System.out.println("\nSuma liczb w tablicy = " + sum + "\nRozmiar tablicy = " + testArray.length);

        //Then
        Assert.assertEquals(0, resultEmpty, 0);
        Assert.assertEquals(4.5, resultArray, 0);
    }

    @Test
    public void testGetAverageVersion3(){
        //Given
        int[] testEmptyArray = new int[] {};
        int[] testArray = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        //When
        System.out.println("Pusta tablica");
        double resultEmpty = ArrayOperations.getAverageVersion3(testEmptyArray);
        System.out.println("\nWypelniona tablica ");
        double resultArray = ArrayOperations.getAverageVersion3(testArray);

        long sum = Arrays.stream(testArray)
                .sum();

        System.out.println("\nSuma liczb w tablicy = " + sum + "\nRozmiar tablicy = " + testArray.length);

        //Then
        Assert.assertEquals(0, resultEmpty, 0);
        Assert.assertEquals(4.5, resultArray, 0);
    }


    @Test
    public void exampleStaticArrayStream(){
        //Given
        int[] testArray = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Arrays.stream(testArray)
                .forEach(System.out::println);
    }
}
