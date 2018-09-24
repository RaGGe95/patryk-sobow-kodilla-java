package com.kodilla.patterns.prototype.library;

public interface copyInterface<T> {
    T deepCopy() throws CloneNotSupportedException;
}
