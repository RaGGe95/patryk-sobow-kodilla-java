package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int ID;
    private final String name;
    private final char gender;
    private final LocalDate birthDate;
    private final int quantityOfPublishedPost;

    public ForumUser(int ID, String name, char gender, LocalDate birthDate, int quantityOfPublishedPost) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.quantityOfPublishedPost = quantityOfPublishedPost;
    }

    public boolean isYoungerThan20() {
        if ( LocalDate.now().getYear() - this.getBirthDate().getYear() > 20)
            return false;
        else if (  LocalDate.now().getYear() - this.getBirthDate().getYear()  < 20)
            return true;

        return (   this.getBirthDate().getMonthValue() >= LocalDate.now().getMonthValue()
                && this.getBirthDate().getDayOfMonth() > LocalDate.now().getDayOfMonth());
    }

    /*
                1998.08.15
                2018.08.15
                 */

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getQuantityOfPublishedPost() {
        return quantityOfPublishedPost;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", quantityOfPublishedPost=" + quantityOfPublishedPost +
                '}';
    }
}
