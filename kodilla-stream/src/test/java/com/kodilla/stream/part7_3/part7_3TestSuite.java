package com.kodilla.stream.part7_3;

import com.kodilla.stream.part7_3.book.Book;
import com.kodilla.stream.part7_3.book.BookDirectory;
import com.kodilla.stream.part7_3.person.People;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class part7_3TestSuite {
    @Test
    public void examplePeopleShowList(){
        People.getList().stream()
                .forEach(System.out::println);
    }

    @Test
    public void examplePeopleMapList(){
        People.getList().stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);
    }

    @Test
    public void examplePeopleMapListVersion2(){
        People.getList().stream()
                .map(String::toUpperCase)
                .forEach(s -> System.out.println(s));
    }

    @Test
    public void examplePeopleFilterList() {
        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);
    }

    @Test
    public void examplePeopleFilterAndMapList() {
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);
    }
    /*
    W kodzie zastosowano kaskadowe połączenie operacji filtrujących oraz transformujących strumień:

w linii nr 43, wszystkie teksty w obiektach zamieniane są na teksty pisane wielkimi literami poprzez wywołanie dla każdego obiektu kodu,
wskazanego referencją do metody toUpperCase() klasy String,

w linii nr 44, przy pomocy wyrażenia lambda odfiltrowane zostają jedynie te teksty, których długość jest większa od 11 znaków,
w linii nr 45, teksty obiektów zastępowane są nowymi.
Ze starego tekstu pobierane są znaki od początku napisu do spacji (plus dwa znaki — sama spacja oraz pierwsza litera nazwiska),
a na końcu dodawana jest kropka,

w linii nr 46, odfiltrowane zostają jedynie te obiekty, których pierwszą literą imienia jest litera M,
w linii nr 47, obiekty ze strumienia wynikowego są wyświetlane na ekranie konsoli przy pomocy kolektora forEach() z referencją do metody System.out::println.
     */

    @Test
    public void exampleBookFilterList(){
        BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);
    }

    @Test
    public void exampleBookCollectToList(){
        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);
    }

    @Test
    public void exampleBookCollectToMap(){
        BookDirectory theBookDirectory = new BookDirectory();

        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }

    @Test
    public void exampleBookCollectJoining(){
        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);
    }

}
