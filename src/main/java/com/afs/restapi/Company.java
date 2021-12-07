package com.afs.restapi;

import java.util.LinkedList;
import java.util.List;

public class Company {
    private Integer id;
    private String companyName;
    private List<Employee> employees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Company(int id,  String companyName, List<Employee> employees){
        this.id = id;
        this.companyName = companyName;
        this.employees = employees;
    }
}
