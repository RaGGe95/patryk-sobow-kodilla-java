package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Test: TaskList";

    @Test
    public void testTaskListDaoSave(){
        //Given
        TaskList taskList = new TaskList("TaskList-1", DESCRIPTION);

        //When
        taskListDao.save(taskList);

        //Then
        int id = taskList.getId();
        TaskList readTask = taskListDao.findOne(id);
        Assert.assertEquals(id, readTask.getId());

        //Clean-up
        taskListDao.delete(id);
    }

    @Test
    public void testFindByListName(){
        //Given
        TaskList taskList = new TaskList("TaskList-1", DESCRIPTION);
        taskListDao.save(taskList);
        String taskListName = taskList.getListName();

        //When
        List<TaskList> readTask = taskListDao.findByListName(taskListName);

        //Then
        Assert.assertEquals(1, readTask.size());

        //Clean-up
        int id = readTask.get(0).getId();
        taskListDao.delete(id);
    }
}
