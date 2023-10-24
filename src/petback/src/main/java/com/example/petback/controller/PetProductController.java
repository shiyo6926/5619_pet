package com.example.petback.controller;

import com.example.petback.entity.PetProduct;
import com.example.petback.service.PetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetProductController {
    private final PetProductService petProductService;

    @Autowired
    public PetProductController(PetProductService petProductService) {
        this.petProductService = petProductService;
    }

    @PostMapping("/products")
    public String createProduct(@RequestBody PetProduct product) {
        String result = petProductService.createProduct(product);
        if (result.equals("success")) {
            return "{\"productID\":\"" + product.getProductId() + "\", " +
                    "\"reason\":\"success\"," +
                    "\"userID\":\"" + product.getUserId() + "\", " +
                    "\"productName\":\"" + product.getProductName() + "\", " +
                    "\"pet\":\"" + product.getTag() + "\", " +
                    "\"productInformation\":\"" + product.getProductInformation() + "\"}";
        } else {
            return "{\"create_product_success\":\"" + result + "\"}";
        }
    }
}

