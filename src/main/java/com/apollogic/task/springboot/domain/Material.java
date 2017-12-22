package com.apollogic.task.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO class representing material entity. Json property helps to map data from external API to objects.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Material {

    @JsonProperty("ID")
    private int ID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("companyID")
    private int companyID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }
}
