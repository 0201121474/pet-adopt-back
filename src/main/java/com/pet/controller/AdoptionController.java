package com.pet.controller;

import com.pet.dao.AdoptionMapper;
import com.pet.entity.Adoption;
import com.pet.service.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class AdoptionController {


    @Autowired
    AdoptionService adoptionService;

    @PostMapping("/adoption/insert")
    public String insertAdoption(@RequestBody Adoption adoption) {

        String res = adoptionService.addAdoption(adoption);
        return res;

    }

    @DeleteMapping("/adoption/delete/{id}")
    public String deleteAdoption(@PathVariable("id") Long id) {

        String res = adoptionService.deleteAdoption(id);
        return res;

    }


    @GetMapping("/adoption/queryAll/{userId}")
    public List<Adoption> queryAllAdoption(@PathVariable("userId") Long userId) {

        List<Adoption> adoptions = adoptionService.queryAdoptions(userId);
        return adoptions;

    }

    @GetMapping("/adoption/accept/{adoptionId}")
    public String setPetAdopt(@PathVariable("adoptionId") Long adoptionId) {
        String res = adoptionService.acceptAdoption(adoptionId);
        return res;
    }

    @PutMapping("/adoption/refuse/{adoptionId}")
    public String updateAdoption(@PathVariable("adoptionId") Long adoptionId) {

        String res = adoptionService.refuseAdoption(adoptionId);
        return res;

    }


}
