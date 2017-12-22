package com.apollogic.task.springboot.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO class representing company entity. Json property helps to map data from external API to objects.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {

    @JsonProperty("companyID")
    private int companyID;
    @JsonProperty("companyName")
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }
}
