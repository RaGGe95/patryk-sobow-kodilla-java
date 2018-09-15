package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task{
    private String taskName;
    private String where;
    private String using;
    private boolean isExecuted = false;
    
    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }
    
    @Override
    public void executeTask() {
        if (!isExecuted) {
            isExecuted = true;
        } else {
            System.out.println("Already executed");
        }
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }
    
    public String getTaskName() {
        return taskName;
    }

    public String getWhere() {
        return where;
    }

    public String getUsing() {
        return using;
    }

}
