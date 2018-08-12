package com.kodilla.testing.library;

public class LibraryUser {
    private final String firstName;
    private final String lastname;
    private final String peselId;

    public LibraryUser(String firstName, String lastname, String peselId) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.peselId = peselId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPeselId() {
        return peselId;
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", peselId='" + peselId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryUser that = (LibraryUser) o;

        if (!getFirstName().equals(that.getFirstName())) return false;
        if (!getLastname().equals(that.getLastname())) return false;
        return getPeselId().equals(that.getPeselId());
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastname().hashCode();
        result = 31 * result + getPeselId().hashCode();
        return result;
    }
}
