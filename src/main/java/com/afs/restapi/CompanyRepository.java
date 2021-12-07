package com.afs.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CompanyRepository {
    private List<Company> companies = new ArrayList<>();

    public CompanyRepository() {
        List<Employee> employeeListinCompany1 = new ArrayList<>();
        employeeListinCompany1.add(new Employee(1, "Mary", 23, "Female", 20000));
        employeeListinCompany1.add(new Employee(2, "Gloria", 22, "Female", 34000));
        employeeListinCompany1.add(new Employee(3, "Anna", 21, "Female", 30000));
        employeeListinCompany1.add(new Employee(4, "Brian", 21, "Male", 31000));
        companies.add(new Company(1, "OOCL", employeeListinCompany1));

        List<Employee> employeeListinCompany2 = new ArrayList<>();
        employeeListinCompany2.add(new Employee(1, "Jenny", 23, "Female", 17000));
        employeeListinCompany2.add(new Employee(2, "Yoyo", 27, "Female", 23500));
        employeeListinCompany2.add(new Employee(3, "Alex", 19, "Female", 16000));
        employeeListinCompany2.add(new Employee(4, "Ben", 32, "Male", 38000));
        companies.add(new Company(2, "COSCO", employeeListinCompany2));
    }

    public List<Company> findAll() {
        return companies;
    }

    public Company findById(Integer id) {
        return companies.stream().filter(company -> company.getId().equals(id))
                .findFirst()
                .orElseThrow(NoMatchIDFoundException::new);
    }

    public List<Employee> findEmployeesByCompanyId(int id) {
        return companies.stream().filter(company -> company.getId().equals(id))
                .findFirst()
                .orElseThrow(NoMatchIDFoundException::new)
                .getEmployees();
    }

    public List<Company> findByPage(Integer page, Integer pageSize) {
        return companies.stream()
                .skip((long) (page-1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public Company create(Company company) {
        Integer nextId = companies.stream()
                .mapToInt(Company::getId)
                .max()
                .orElse(0) + 1;
        company.setId(nextId);
        companies.add(company);
        return company;
    }

    public Company delete(Integer id) {
        return null;
    }

    public Company save(Integer id, Company updatedCompany) {
        Company company = findById(id);
        companies.remove(company);
        companies.add(updatedCompany);
        return updatedCompany;
    }
}
