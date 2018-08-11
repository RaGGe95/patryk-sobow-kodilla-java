package com.kodilla.testing.forum.statistics;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculateAdvStatisticsTestSuite {
    static int testCounter = 0;

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    // test for condition: Posts quantity = 0
    public void testPostsStatisticsFirstWithMock() {
        //Given
        Statistics statistics = mock(Statistics.class);
        when(statistics.postsCount()).thenReturn(0);
        CalculateAdvStatistics advStatObject = new CalculateAdvStatistics(statistics);

        //When
        int quantityOfPosts = advStatObject.getPostsQuantity();

        //Then
        Assert.assertEquals(0, quantityOfPosts);
        Assert.assertEquals(0, advStatObject.getAverageCommentsOnPost());
        Assert.assertEquals(0, advStatObject.getAveragePostsOnUser());
    }


    @Test
    // test for condition: Posts quantity = 1000
    public void testPostsStatisticsSecondWithMock() {
        //Given
        Statistics statistics = mock(Statistics.class);
        when(statistics.postsCount()).thenReturn(1000);
        CalculateAdvStatistics advStatObject = new CalculateAdvStatistics(statistics);

        //When
        int quantityOfPosts = advStatObject.getPostsQuantity();

        //Then
        Assert.assertEquals(1000, quantityOfPosts);
        Assert.assertEquals(0, advStatObject.getAverageCommentsOnPost());
        Assert.assertEquals(0, advStatObject.getAveragePostsOnUser());
    }

    @Test
    // test for condition: Comments quantity = 0
    public void testCommentsStatisticsFirstWithMock() {
        //Given
        Statistics statistics = mock(Statistics.class);
        when(statistics.commentsCount()).thenReturn(0);
        CalculateAdvStatistics advStatObject = new CalculateAdvStatistics(statistics);

        //When
        int quantityOfComments = advStatObject.getCommentsQuantity();

        //Then
        Assert.assertEquals(0, quantityOfComments);

        Assert.assertEquals(0, advStatObject.getAverageCommentsOnUser());
        Assert.assertEquals(0, advStatObject.getAverageCommentsOnPost());
    }
    @Test
    // test for condition: Comments quantity < Posts quantity
    public void testCommentsStatisticsSecondWithMock() {
        //Given
        Statistics statistics = mock(Statistics.class);
        when(statistics.postsCount()).thenReturn(1000);
        when(statistics.commentsCount()).thenReturn(100);
        CalculateAdvStatistics advStatObject = new CalculateAdvStatistics(statistics);

        //When
        int quantityOfComments = advStatObject.getCommentsQuantity();
        int quantityOfPosts = advStatObject.getPostsQuantity();

        //Then
        Assert.assertEquals(1000, quantityOfPosts);
        Assert.assertEquals(100, quantityOfComments);

        Assert.assertEquals(0, advStatObject.getAverageCommentsOnUser());
        Assert.assertEquals(1/10, advStatObject.getAverageCommentsOnPost());
    }
    @Test
    // test for condition: Comments quantity > Posts quantity
    public void testCommentsStatisticsThirdWithMock() {
        //Given
        Statistics statistics = mock(Statistics.class);
        when(statistics.postsCount()).thenReturn(100);
        when(statistics.commentsCount()).thenReturn(1000);
        CalculateAdvStatistics advStatObject = new CalculateAdvStatistics(statistics);

        //When
        int quantityOfComments = advStatObject.getCommentsQuantity();
        int quantityOfPosts = advStatObject.getPostsQuantity();

        //Then
        Assert.assertEquals(100, quantityOfPosts);
        Assert.assertEquals(1000, quantityOfComments);

        Assert.assertEquals(0, advStatObject.getAverageCommentsOnUser());
        Assert.assertEquals(10, advStatObject.getAverageCommentsOnPost());
    }

    @Test
    // test for condition: Users quantity = 0
    public void testUsersStatisticsFirstWithMock() {
        //Given
        Statistics statistics = mock(Statistics.class);
        List<String> namesList = new ArrayList<>();
        when(statistics.usersNames()).thenReturn(namesList);
        CalculateAdvStatistics advStatObject = new CalculateAdvStatistics(statistics);

        //When
        int quantityOfUsers = advStatObject.getUsersQuantity();

        //Then
        Assert.assertEquals(0, quantityOfUsers);

        Assert.assertEquals(0, advStatObject.getAverageCommentsOnUser());
        Assert.assertEquals(0, advStatObject.getAveragePostsOnUser() );
    }

    @Test
    // test for condition: Users quantity = 100
    public void testUsersStatisticsSecondWithMock() {
        //Given
        Statistics statistics = mock(Statistics.class);

        List<String> namesList = new ArrayList<>(150);
        for (int i = 0; i < 100; i++){
            namesList.add("Witam");
        }

        when(statistics.usersNames()).thenReturn(namesList);
        CalculateAdvStatistics advStatObject = new CalculateAdvStatistics(statistics);

        //When
        int quantityOfUsers = advStatObject.getUsersQuantity();

        //Then
        Assert.assertEquals(100, quantityOfUsers);

        Assert.assertEquals(0, advStatObject.getAverageCommentsOnUser());
        Assert.assertEquals(0, advStatObject.getAveragePostsOnUser() );
    }
}
