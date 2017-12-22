package com.apollogic.task.springboot.controller;

import com.apollogic.task.springboot.domain.Company;
import com.apollogic.task.springboot.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller class.
 * It contains RequestMapping methods and communicates with service.
 */
@RestController
@RequestMapping("/")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/company/{companyID}", method = RequestMethod.GET)
    Company getCompany(@PathVariable("companyID") int companyID) throws Exception {
        return companyService.getCompany(companyID);
    }

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    Iterable<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @RequestMapping(value = "/company", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void addCompany(@RequestBody Company company) throws Exception {
        companyService.addCompany(company);
    }

    @RequestMapping(value = "/company/{companyID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void updateCompany(@PathVariable("companyID") int companyID, @RequestBody Company company) throws Exception {
        company.setCompanyID(companyID);
        companyService.updateCompany(company);
    }

    @RequestMapping(value = "/company/{companyID}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    void deleteCompany(@PathVariable("companyID") int companyID) throws Exception {
        companyService.deleteCompany(companyID);
    }

    @RequestMapping(value = "/company", method = RequestMethod.PATCH)
    @ResponseStatus(value = HttpStatus.OK)
    void resetCompanyList() {
        companyService.resetCompanyList();
    }

}
