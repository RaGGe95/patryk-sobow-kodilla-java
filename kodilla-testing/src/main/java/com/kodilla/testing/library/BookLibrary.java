package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
        LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition_FROM_CLASS_BookLibrary(String titleFragment) {

        List<Book> bookList = new ArrayList<>();

        if (titleFragment.length() < 3) return bookList;

        List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);

        if (resultList.size() > 20) return bookList;

        return resultList;
    }


    public List<Book> listBooksInHandsOf_FROM_CLASS_BookLibrary(LibraryUser libraryUser) {


        // libraryDatabse.listBooksInHandsOf(LibraryUser libraryUser);


        return null;
    }
}