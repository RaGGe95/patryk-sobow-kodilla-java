package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("toDo")
    private TaskList toDo;

    @Autowired
    @Qualifier("inProgress")
    private TaskList inProgress;

    @Autowired
    @Qualifier("done")
    private TaskList done;

    @Bean
    public Board getBoard() {
        return new Board(toDo, inProgress, done);
    }


    @Bean(name = "toDo")
    @Scope ("prototype")
    public TaskList getTaskListOne(){
        return new TaskList();
    }

    @Bean(name = "inProgress")
    @Scope ("prototype")
    public TaskList getTaskListTwo(){
        return new TaskList();
    }

    @Bean(name = "done")
    @Scope ("prototype")
    public TaskList getTaskListThree(){
        return new TaskList();
    }

}
