package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testDrivingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task drivingTask = taskFactory.makeTask(TaskFactory.DRIVING);

        String taskName = drivingTask.getTaskName();
        boolean isExecuted = drivingTask.isTaskExecuted();

        //Then
        Assert.assertEquals("Jedź po alkohol", taskName);
        Assert.assertEquals(false, isExecuted);
    }

    @Test
    public void testShoppingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPING);

        String taskName = shoppingTask.getTaskName();
        shoppingTask.executeTask();
        boolean isExecuted = shoppingTask.isTaskExecuted();

        //Then
        Assert.assertEquals("Kup alkohol", taskName);
        Assert.assertEquals(true, isExecuted);
    }

    @Test
    public void testPaintingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task paintingTask = taskFactory.makeTask(TaskFactory.PAINTING);

        String taskName = paintingTask.getTaskName();
        boolean isExecuted = paintingTask.isTaskExecuted();

        //Then
        Assert.assertEquals("Pomaluj dom", taskName);
        Assert.assertEquals(false, isExecuted);
    }
}
