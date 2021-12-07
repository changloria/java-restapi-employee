package com.afs.restapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies")
public class CompanyController {
    CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Company getCompanyByID(@PathVariable Integer id){
        return companyRepository.findById(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByCompanyId(@PathVariable int id){
        return companyRepository.findEmployeesByCompanyId(id);
    }
}
