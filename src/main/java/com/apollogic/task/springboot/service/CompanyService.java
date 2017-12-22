package com.apollogic.task.springboot.service;

import com.apollogic.task.springboot.client.SpringBootRestClient;
import com.apollogic.task.springboot.domain.Company;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Service class for Spring. Application doesn't use any solid database (like H2).
 * Instead just use a HashMap to store the data objects (companies) through a service layer class.
 */
@Service
public class CompanyService {

    //HashMap to store the objects
    Map<Integer, Company> companies = SpringBootRestClient.loadCompanyList();

    /**
     * Method for adding single objects(company) to HashMap. Method always checks if there are objects with the same
     * ID fields. Mathod puts object into the HashMap with same key value as object's ID field.
     * @param company
     * @throws Exception in case there is object with the same ID field value in HashMap.
     */
    public void addCompany(Company company) throws Exception {
        if (companies.containsKey(company.getCompanyID())) {
            throw new Exception("Company already exists");
        } else {
            companies.put(company.getCompanyID(), company);
        }
    }

    /**
     * Method for fetching all obejcts (companies) stored as values in HashMap.
     * @return all collection of values stored in HashMap.
     */
    public Iterable<Company> getCompanies() {
        return companies.values();
    }

    /**
     * Method for fetching single obejcts (companies) stored as values in HashMap.
     * @param ID
     * @return single objects (company) stored as value in HashMap
     * @throws Exception in case there is no object with the given ID field in HashMap.
     */
    public Company getCompany(int ID) throws Exception {

        if (companies.containsKey(ID)) {
            return companies.get(ID);
        } else {
            throw new Exception("Company not found");
        }
    }

    /**
     * Method for updating single objects (companies) stored as values in HashMap.
     * @param company
     * @throws Exception in case there is no object with the given ID field in HashMap.
     */
    public void updateCompany(Company company) throws Exception {
        if (companies.containsKey(company.getCompanyID())) {
            companies.put(company.getCompanyID(), company);
        } else {
            throw new Exception("Company not found");
        }
    }

    /**
     * Method for deleting single objects (companies) stored as values in HashMap.
     * @param ID
     * @throws Exception in case there is no object with the given ID field in HashMap.
     */
    public void deleteCompany(int ID) throws Exception {
        if (companies.containsKey(ID)) {
            companies.remove(ID);
        } else {
            throw new Exception("Company not found");
        }
    }

    /**
     * Simple method for resetting HashMap to initial state. Calling this method restores keys and values (objects)
     * retrieved from the external API
     */
    public void resetCompanyList() {
        companies = SpringBootRestClient.loadCompanyList();
    }

}
