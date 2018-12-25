package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TaskDaoTestSuite {
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private TaskFinancialDetailsDao taskFinancialDetailsDao;

    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    public void testTaskDaoSave() {
        //Given
        Task task = new Task(DESCRIPTION, 7);

        //When
        taskDao.save(task);

        //Then
        int id = task.getId();
        Task readTask = taskDao.findOne(id);
        Assert.assertEquals(id, readTask.getId());

        //CleanUp
        taskDao.delete(id);
    }

    @Test
    public void testTaskDaoFindByDuration() {
        //Given
        Task task = new Task(DESCRIPTION, 7);
        taskDao.save(task);
        int duration = task.getDuration();

        //When
        List<Task> readTasks = taskDao.findByDuration(duration);

        //Then
        Assert.assertEquals(1, readTasks.size());

        //CleanUp
        int id = readTasks.get(0).getId();
        taskDao.delete(id);
    }

    @Test
    public void testTaskDaoSaveWithFinancialDetails() {
        //Given
        Task taskTEST1 = new Task(DESCRIPTION, 30);
        Task taskTEST2 = new Task(DESCRIPTION, 30);

        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(1), false);
        Task task = new Task(DESCRIPTION, 30);
        task.setTaskFinancialDetails(tfd1);

        //When


        taskDao.save(Arrays.asList(taskTEST1,taskTEST2,task));

        //Then
        //Assert.assertNotEquals(0, id);

        //CleanUp

        taskDao.delete(task.getId());

    }
}