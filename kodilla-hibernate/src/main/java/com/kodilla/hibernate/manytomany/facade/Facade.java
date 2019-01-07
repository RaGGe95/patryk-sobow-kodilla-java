package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Facade {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    List<Employee> findEmployeeByPartOfName(final String partOfName){
        return employeeDao.findByPartOfName(partOfName);
    }

    List<Company> findCompanyByPartOfName(final String partOfName){
        return companyDao.findByPartOfName(partOfName);
    }

    void saveCompanies(final List<Company> companies){
        companyDao.save(companies);
    }

    void saveEmployees(final List<Employee> employees){
        employeeDao.save(employees);
    }

}
