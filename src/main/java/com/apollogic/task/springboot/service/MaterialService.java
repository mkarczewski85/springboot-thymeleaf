package com.apollogic.task.springboot.service;

import com.apollogic.task.springboot.client.SpringBootRestClient;
import com.apollogic.task.springboot.domain.Material;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Service class for Spring. Application doesn't use any solid database (like H2).
 * Instead just use a HashMap to store the data objects (materials) through a service layer class.
 */
@Service
public class MaterialService {

    //HashMap to store the objects as values
    Map<Integer, Material> materials = SpringBootRestClient.loadMaterialList();

    /**
     * Method for adding single objects(material) to HashMap. Method always checks if there are objects with the same
     * ID fields. Mathod puts object into the HashMap with same key value as object's ID field.
     * @param material
     * @throws Exception in case there is object with the same ID field value in HashMap.
     */
    public void addMaterial(Material material) throws Exception {
        if (materials.containsKey(material.getID())) {
            throw new Exception("Material already exists");
        } else {

            materials.put(material.getID(), material);
        }
    }

    /**
     * Method for fetching all obejcts (materials) stored as values in HashMap.
     * @return all collection of values stored in HashMap.
     */
    public Iterable<Material> getMaterials() {
        return materials.values();
    }

    /**
     * Method for fetching single obejcts (materials) stored as values in HashMap.
     * @param ID
     * @return single objects (material) stored as value in HashMap
     * @throws Exception in case there is no object with the given ID field in HashMap.
     */
    public Material getMaterial(int ID) throws Exception {

        if (materials.containsKey(ID)) {
            return materials.get(ID);
        } else {
            throw new Exception("Material not found");
        }
    }

    /**
     * Method for updating single objects (materials) stored as values in HashMap.
     * @param material
     * @throws Exception in case there is no object with the given ID field in HashMap.
     */
    public void updateMaterial(Material material) throws Exception {
        if (materials.containsKey(material.getID())) {
            materials.put(material.getID(), material);
        } else {
            throw new Exception("Material not found");
        }
    }

    /**
     * Method for deleting single objects (materials) stored as values in HashMap.
     * @param ID
     * @throws Exception in case there is no object with the given ID field in HashMap.
     */
    public void deleteMaterial(int ID) throws Exception {
        if (materials.containsKey(ID)) {
            materials.remove(ID);
        } else {
            throw new Exception("Material not found");
        }
    }

    /**
     * Simple method for resetting HashMap to initial state. Calling this method restores keys and values (objects)
     * retrieved from the external API
     */
    public void resetMaterialList() {
        materials = SpringBootRestClient.loadMaterialList();
    }

}
