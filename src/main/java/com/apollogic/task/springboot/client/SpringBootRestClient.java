package com.apollogic.task.springboot.client;

import com.apollogic.task.springboot.domain.Company;
import com.apollogic.task.springboot.domain.Material;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

public class SpringBootRestClient {

    public static final String REST_SERVICE_URI = "http://193.142.112.220:8337";

    /**
     * Method fetching all companies from external API to local storage.
     * Method uses RestTemplate object to map received JSON to POJO
     * @return map of objects of type 'Company' as values
     */
    @SuppressWarnings("unchecked")
    public static HashMap<Integer, Company> loadCompanyList() {
        RestTemplate restTemplate = new RestTemplate();
        List<Company> companyList = restTemplate.getForObject(REST_SERVICE_URI + "/companyList/", List.class);
        HashMap<Integer, Company> map = new HashMap<>();
        for (int i = 0; i < companyList.size(); i++) {
            map.put((i+1), companyList.get(i));
        }
        return map;
    }

    /**
     * Method for fetching single JSON from external API. Then it maps it to POJO and returns Java object.
     * @param id
     * @return Company type object
     */
    public static Company getCompanyById(int id) {

        RestTemplate restTemplate = new RestTemplate();
        Company company = restTemplate.getForObject(REST_SERVICE_URI + "/materialList?companyID=" + id, Company.class);
        return company;
    }

    /**
     * Method fetching all materials from external API to local storage.
     * Method uses RestTemplate object to map received JSON to POJO
     * @return map of objects of type 'Material' as values
     */
    @SuppressWarnings("unchecked")
    public static HashMap<Integer, Material> loadMaterialList() {
        RestTemplate restTemplate = new RestTemplate();
        List<Material> materialList = restTemplate.getForObject(REST_SERVICE_URI + "/materialList/", List.class);
        HashMap<Integer, Material> map = new HashMap<>();
        for (int i = 0; i < materialList.size(); i++) {
            map.put((i+1), materialList.get(i));
        }
        return map;
    }

    /**
     * Method for fetching single JSON from external API. Then it maps it to POJO and returns Java object.
     * @param id
     * @return Material type object
     */
    private static Material getMaterialDetailsById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        Material material = restTemplate.getForObject(REST_SERVICE_URI + "/materialDetails?ID=" + id, Material.class);
        return material;
    }

}
