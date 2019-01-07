package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/*
funkcja CONCAT łączy ze sobą stringi. symbol % oznacza: Dopasuj 0 lub więcej jakichkolwiek kolejnych znaków
 */

@NamedNativeQueries({
    @NamedNativeQuery(
            name = "Company.findByThreeFirstLetters",
            query = "SELECT * FROM COMPANIES WHERE :PIECE_OF_NAME = SUBSTRING(COMPANY_NAME, 1, 3)",
            resultClass = Company.class
    ),
    @NamedNativeQuery(
            name = "Company.findByPartOfName",
            query = "SELECT * FROM COMPANIES WHERE COMPANY_NAME LIKE CONCAT(:BEGINSWITH, '%')",
            resultClass = Company.class
    )
})

@Entity
@Table(name = "COMPANIES")
public class Company {
    private int id; // PRIMARY KEY
    private List<Employee> employees = new ArrayList<>(); // co to jest?

    private String name;


    private Company() {}

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }
}