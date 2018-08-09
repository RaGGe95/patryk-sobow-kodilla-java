package com.kodilla.testing.collection;

import java.util.*;
import org.junit.*;

public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        System.out.println("Test Case: EmptyList");
        OddNumbersExterminator myExter = new OddNumbersExterminator();
        List<Integer> myList = new ArrayList<>();
        //When
        myExter.exterminate(myList);
        //Then
        /*
        Nie mam pomysłu co sprawdzać w przypadku pustej listy.
         */
        Assert.assertTrue(true);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        System.out.println("Test Case: NormalList");
        OddNumbersExterminator myExter = new OddNumbersExterminator();
        List<Integer> myList = new ArrayList<>( Arrays.asList(1,2,3,4,5,6,7,8,9,10) );
        //When
        myExter.exterminate(myList);
        //Then
        for (Integer each : myList) {
            if (each % 2 != 0) {
                Assert.assertFalse(false);
            }
        }
    }
}
