package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    public void testShowBoard(){
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When&Then
        board.showBoard();
    }

    @Test
    public void testAddOneTask(){
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().addTask("ZRÓB SALTO");
        board.getInProgressList().addTask("IDŹ SPAĆ");
        board.getDoneList().addTask("DOKĄD NOCĄ TUPTA JEŻ");
        //Then
        board.showBoard();

        Assert.assertEquals(1, board.getToDoList().getTasks().size());
        Assert.assertEquals(1, board.getInProgressList().getTasks().size());
        Assert.assertEquals(1, board.getDoneList().getTasks().size());
    }
}
