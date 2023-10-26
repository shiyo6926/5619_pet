package com.example.petback.service;

import com.example.petback.entity.PetProduct;
import com.example.petback.mapper.PetProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetProductService {
    private final PetProductMapper petProductMapper;

    @Autowired
    public PetProductService(PetProductMapper petProductMapper) {
        this.petProductMapper = petProductMapper;
    }

    public String createProduct(PetProduct product) {
        int count = petProductMapper.countProductByName(product.getProductName());
        if (count > 0) {
            return "productName repeat";
        } else {
            petProductMapper.insertPetProduct(product);
            return "success";
        }
    }
}

