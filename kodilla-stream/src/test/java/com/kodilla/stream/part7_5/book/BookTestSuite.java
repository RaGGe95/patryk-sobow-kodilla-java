package com.kodilla.stream.part7_5.book;

import com.kodilla.stream.part7_3.book.Book;
import com.kodilla.stream.part7_3.book.BookDirectory;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.stream.IntStream;

public class BookTestSuite {
    @Test
    public void testGetListUsingFor() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublicatedAfter2007 = 0;
        for(Book book : books) {
            if (book.getYearOfPublication() > 2007) {
                numberOfBooksPublicatedAfter2007++;
            }
        }
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }



    @Test
    public void testGetListUsingIntStream() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .map(n -> 1)
                .sum();
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }
    /*
    W linii nr 40 tworzymy i uruchamiamy strumień elementów typu int o zakresach numerów od 0 do books.size().
    Wynik działania tego strumienia, po jego zakończeniu, zostanie przypisany do zmiennej numberOfBooksPublicatedAfter2007.

    W linii nr 41 odfiltrowujemy tylko te książki, których rok wydania jest większy od 2007.
    Realizujemy to przy pomocy wyrażenia lambda, które otrzymuje na wejściu kolejną wartość indeksu n.
    Do strumienia wyjściowego filtra kierowane są jedynie te numery indeksów (nie książki!),
    które odpowiadają książkom wydanym po roku 2007.
    Sprawdzamy to przy pomocy warunku books.get(n).getYearOfPublication() > 2007.

    W linii nr 42 na wejściu otrzymujemy strumień liczb typu int,
    które są numerami indeksów książek wydanych po 2007 roku w kolekcji books.
    Każdy taki indeks odpowiada jednej książce do "zliczenia".
    Dokonujemy więc transformacji strumienia w taki sposób,
    że do strumienia wyjściowego trafia liczba 1 w miejsce każdego elementu strumienia do zliczenia

    W linii nr 43 zliczamy liczbę "jedynek" w strumieniu wejściowym. Odpowiada ona liczbie książek wydanych po roku 2007 w kolekcji.
     */


    @Test
    public void testGetListUsingIntStreamVersion2() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        long numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .count(); // metoda count jest kolektorem ,który zlicza obiekty w strumieniu
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }
}