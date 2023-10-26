package com.example.petback.controller;

import com.example.petback.entity.PetProduct;
import com.example.petback.service.PetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/petproduct")
public class PetProductController {
    @Autowired
    private PetProductService petProductService;
    @PostMapping("/searchbypet")
    public ResponseEntity<List<PetProduct>> getPetProductsBypet(@RequestBody PetProduct petProduct) {

        List<PetProduct> petProductsBypet = petProductService.getPetProductsBypet(petProduct);
        return ResponseEntity.ok(petProductsBypet);
    }
    @PostMapping("/search")
    public ResponseEntity<List<PetProduct>> getPetProducts() {

        List<PetProduct> petProducts = petProductService.getPetProducts();
        return ResponseEntity.ok(petProducts);
    }
}

