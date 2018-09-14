package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<String> tasks;

    public TaskList(){
        tasks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "tasks=" + tasks +
                '}';
    }

    public void addTask(String task){
        tasks.add(task);
    }

    // return copy
    public List<String> getTasks() {
        return new ArrayList<>(tasks);
    }
}
