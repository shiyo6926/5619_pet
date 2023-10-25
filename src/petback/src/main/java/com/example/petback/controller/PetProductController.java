package com.example.petback.controller;

import com.example.petback.entity.PetProduct;
import com.example.petback.service.PetProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/petproduct")
public class PetProductController {
    private PetProductService petProductService;
    @PostMapping("/searchbytag")
    public ResponseEntity<List<PetProduct>> getPetProductsBytag(@RequestBody PetProduct petProduct) {

        List<PetProduct> petProductsBytag = petProductService.getPetProductsBytag(petProduct);
        return ResponseEntity.ok(petProductsBytag);
    }
    @PostMapping("/search")
    public ResponseEntity<List<PetProduct>> getPetProducts() {

        List<PetProduct> petProducts = petProductService.getPetProducts();
        return ResponseEntity.ok(petProducts);
    }
}

