package com.kodilla.exception.io;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    public void readFile() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
        Path path = Paths.get(file.getPath());
    }
}
