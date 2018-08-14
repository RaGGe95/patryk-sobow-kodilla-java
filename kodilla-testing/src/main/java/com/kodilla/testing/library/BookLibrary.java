package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
        LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithConditionBookLibrary(String titleFragment) {

        List<Book> bookList = new ArrayList<>();

        if (titleFragment.length() < 3) return bookList;

        List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);

        if (resultList.size() > 20) return bookList;

        return resultList;
    }


    public List<Book> listBooksInHandsOfBookLibrary(LibraryUser libraryUser) {

        List<Book> bookList = new ArrayList<>();

        List<Book> resultList = libraryDatabase.listBooksInHandsOf(libraryUser);

        if (resultList.size() == 0) {
            return bookList;
        }

        return resultList;
    }

    boolean rentABook_FROM_CLASS_BookLibrary(LibraryUser libraryUser, Book book) {

        return false;
    }

}