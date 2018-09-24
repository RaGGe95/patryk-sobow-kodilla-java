package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.time.LocalDate;

public final class Book extends Prototype<Book> implements copyInterface<Book> {
    private String title;
    private String author;
    private LocalDate publicationDate;

    public Book(final String title, final String author, final LocalDate publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return "        Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }

    Book shallowCopy() throws CloneNotSupportedException{
        return super.clone();
    }

    public Book deepCopy() throws CloneNotSupportedException{
        Book clonedBook= super.clone();
        clonedBook.title = this.title;
        clonedBook.author = this.author;
        clonedBook.publicationDate = LocalDate.of(
                this.publicationDate.getYear(),
                this.publicationDate.getMonthValue(),
                this.publicationDate.getDayOfMonth());

        return clonedBook;
    }
}