package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class FacadeTest {
    @Autowired
    private Facade facade;

    @Test
    public void company(){
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        facade.saveCompanies(Arrays.asList(softwareMachine, dataMaesters, greyMatter));

        //When
        // w przypadku kiedy nie znajdzie rekordu w bazie danych nie zostaje wyrzucany wyjątek ponieważ to nie zostało zaimplementowane,
        // musimy ręcznie dopisać taką funkcjonalność jeżeli chcemy żeby wyskakiwał wyjątek w przypadku gdy nie znaleziono obiektu...
        List<Company> result = facade.findCompanyByPartOfName("Sadwo");

        //Then
        //Assert.assertEquals(1, result.size());
        System.out.println("\n\nZnaleziony obiekt:");
        System.out.println(result.toString() +"\n\n");
    }

    @Test
    public void employee(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        facade.saveEmployees(Arrays.asList(johnSmith, stephanieClarckson, lindaKovalsky));

        //When
        List<Employee> result = facade.findEmployeeByPartOfName("Jo");

        //Then
        Assert.assertEquals(1, result.size());
        System.out.println("\n\nZnaleziony obiekt:");
        System.out.println(result.toString() +"\n\n");

    }

}