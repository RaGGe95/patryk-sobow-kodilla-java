package com.kodilla.stream.part7_3.forumuser;

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

    public boolean isYoungerThan20Version2() {
        LocalDate twentyYearsEarlier = LocalDate.now().minusYears(20);
        LocalDate birthDate = this.getBirthDate();

        int result = birthDate.compareTo(twentyYearsEarlier);

        if (result < 0)
            return false;
        else
            return true;
    }

    public boolean isYoungerThan20Version3() {
        LocalDate twentyYearsEarlier = LocalDate.now().minusYears(20);
        LocalDate birthDate = this.getBirthDate();

        return twentyYearsEarlier.isBefore(birthDate);
    }


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
