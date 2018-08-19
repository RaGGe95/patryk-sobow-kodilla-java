package com.kodilla.stream.part7_1.beautifier;


public class PoemBeautifier {
    public void beautifyAndShow(String string, PoemDecorator poemDecorator){
        String result = poemDecorator.decorate(string);
        System.out.println(result);
    }
}