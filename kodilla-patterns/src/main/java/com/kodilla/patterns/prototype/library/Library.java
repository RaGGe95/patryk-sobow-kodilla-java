package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

public final class Library<T extends copyInterface<T>> extends Prototype<Library> {
    private String name;
    private Set<T> objects = new HashSet<>();

    Library(final String name) {
        this.name = name;
    }

    void add(T object){
        objects.add(object);
    }
    void remove(Book book) {
        objects.remove(book);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    Set<T> getObjects() {
        return new HashSet<>(objects);
    }

    @Override
    public String toString() {
        String s = "Library{" + name + '}' + '\n';
        for(T object : objects) {
            s = s + object.toString() + '\n';
        }
        return s;
    }

    Library shallowCopy() throws CloneNotSupportedException{
        return super.clone();
    }

    Library deepCopy() throws CloneNotSupportedException{
        Library clonedLibrary = super.clone();

        clonedLibrary.name = this.name;
        clonedLibrary.objects = new HashSet<>();

        for(T object : objects){
            clonedLibrary.add(object.deepCopy());
        }
        return clonedLibrary;
    }


}