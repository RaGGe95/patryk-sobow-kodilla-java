package com.kodilla.testing.library;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {
    private static int testCounter = 0;

    @Before
    public void beforeEverytest() {
        testCounter++;
        System.out.println("Preparing to execute test number: " + testCounter);
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> resultList = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultList.add(book1);
        resultList.add(book2);
        resultList.add(book3);
        resultList.add(book4);

        when(bookLibrary.listBooksWithConditionBookLibrary("Secret")).thenReturn(resultList);
        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithConditionBookLibrary("Secret");

        //Then
        assertEquals(4,theListOfBooks.size() );
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> resultListOfBooks0 = new ArrayList<>();
        List<Book> resultListOfBooks15 = generateListOfNBooks(15);
        List<Book> resultListOfBooks40 = generateListOfNBooks(40);

        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOfBooks0);

        when(libraryDatabaseMock.listBooksWithCondition("15 Books"))
                .thenReturn(resultListOfBooks15);

        when(libraryDatabaseMock.listBooksWithCondition("40 Books"))
                .thenReturn(resultListOfBooks40);
        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithConditionBookLibrary("Zero Books");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithConditionBookLibrary("15 Books");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithConditionBookLibrary("40 Books");

        //Then
        assertEquals(0,theListOfBooks0.size() );
        assertEquals(15,theListOfBooks15.size() );
        assertEquals(0,theListOfBooks40.size() );
    }


    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> resultList = generateListOfNBooks(10);

        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultList);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithConditionBookLibrary("An");

        // Then
        assertEquals(0, theListOfBooks.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());

    }






    @Test
    public void testListBooksInHands() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        LibraryUser libraryUser1 = new LibraryUser("Stasiu1", "Bargiełło", "123" );
        LibraryUser libraryUser2 = new LibraryUser("Stasiu2", "Bargiełło", "123" );
        LibraryUser libraryUser3 = new LibraryUser("Stasiu3", "Bargiełło", "123" );

        List<Book> resultListZeroBook = generateListOfNBooks(0);
        List<Book> resultListOneBook = generateListOfNBooks(1);
        List<Book> resultListFiveBooks = generateListOfNBooks(5);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1))
                .thenReturn(resultListZeroBook);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser2))
                .thenReturn(resultListOneBook);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser3))
                .thenReturn(resultListFiveBooks);
        // When
        List<Book> theListOfUserBooks1 = bookLibrary.listBooksInHandsOfBookLibrary(libraryUser1);
        List<Book> theListOfUserBooks2 = bookLibrary.listBooksInHandsOfBookLibrary(libraryUser2);
        List<Book> theListOfUserBooks3 = bookLibrary.listBooksInHandsOfBookLibrary(libraryUser3);
        // Then

        assertEquals(0, theListOfUserBooks1.size());
        assertEquals(1, theListOfUserBooks2.size());
        assertEquals(5, theListOfUserBooks3.size());
    }


}