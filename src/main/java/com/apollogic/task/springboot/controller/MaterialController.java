package com.apollogic.task.springboot.controller;

import com.apollogic.task.springboot.domain.Material;
import com.apollogic.task.springboot.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * RestController class.
 * It contains RequestMapping methods and communicates with service.
 */
@RestController
@RequestMapping("/")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @RequestMapping(value = "/material/{ID}", method = RequestMethod.GET)
    Material getMaterial(@PathVariable("ID") int ID) throws Exception {
        return materialService.getMaterial(ID);
    }

    @RequestMapping(value = "/material", method = RequestMethod.GET)
    Iterable<Material> getMaterials() {
        return materialService.getMaterials();
    }

    @RequestMapping(value = "/material", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void addMaterial(@RequestBody Material material) throws Exception {
        materialService.addMaterial(material);
    }

    @RequestMapping(value = "/material/{ID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void updateMaterial(@PathVariable("ID") int ID, @RequestBody Material material) throws Exception {
        material.setID(ID);
        materialService.updateMaterial(material);
    }

    @RequestMapping(value = "/material/{ID}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    void deleteMaterial(@PathVariable("ID") int ID) throws Exception {
        materialService.deleteMaterial(ID);
    }

    @RequestMapping(value = "/material", method = RequestMethod.PATCH)
    @ResponseStatus(value = HttpStatus.OK)
    void resetMaterialList(){
        materialService.resetMaterialList();
    }

}
