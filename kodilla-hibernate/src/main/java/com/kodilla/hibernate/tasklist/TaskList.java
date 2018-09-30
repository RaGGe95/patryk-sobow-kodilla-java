package com.kodilla.hibernate.tasklist;


import com.kodilla.hibernate.task.Task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TASKLIST")
public class TaskList {
    private int id; // PRIMARY KEY
    private List<Task> tasks = new ArrayList<>(); // Task.class use this to construct FOREIGN KEY

    private String listName;
    private String description;


    private TaskList() {}

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }


    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @OneToMany(
            targetEntity = Task.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "taskList"
    )
    public List<Task> getTasks() {
        return tasks;
    }





    @NotNull
    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }



    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}
