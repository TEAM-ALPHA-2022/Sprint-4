package com.Sprint3.sprint3.controller;

import com.Sprint3.sprint3.entities.Enterprise;
import com.Sprint3.sprint3.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EnterpriseController {

    @Autowired
    EnterpriseService enterpriseService;

    @GetMapping("/enterprises")
    private List<Enterprise> seeEnterprises(){
        return enterpriseService.seeEnterprises();
    }

    @PostMapping("/enterprises")
    private void createEnterprise(@RequestBody Enterprise enterprise){
        enterpriseService.CreateAndUpdateEnterprise(enterprise);
    }

    @GetMapping("/enterprises/{id}")
    public Enterprise searchEnterprise(@PathVariable long id){
        return enterpriseService.seeEntrepiseId(id);
    }

    @DeleteMapping("/enterprises/{id}")
    private void deleteEnterprise(@PathVariable("id") Long id){
        enterpriseService.deleteEnterprise(id);
    }

    @PatchMapping("/enterprises/{id}")
    public void updateEnterprise(@PathVariable long id, @RequestBody Map<Object, Object> dataToUpdate){
        enterpriseService.updateEnterprise(id,dataToUpdate);
    }

}
