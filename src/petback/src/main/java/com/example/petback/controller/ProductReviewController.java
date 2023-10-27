package com.example.petback.controller;


import com.example.petback.entity.ProductReview;
import com.example.petback.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productreview")
public class ProductReviewController {
    @Autowired
    private ProductReviewService productReviewService;

    @PostMapping("/add")
    public ProductReview addProductReview(
            @RequestBody ProductReview productreview) {
        ProductReview response =productReviewService.addProductReview(productreview);
        return response;
    }

    @PostMapping("/edit")
    public ProductReview editProductReview(
            @RequestBody ProductReview productreview) {
        ProductReview response = productReviewService.editProductReview(productreview);
        return response;
    }

    @PostMapping("/delete")
    public ProductReview deleteProductReview(
            @RequestBody ProductReview productreview) {
        ProductReview response = productReviewService.deleteProductReview(productreview);
        return response;
    }

    @PostMapping("/get")
    public ResponseEntity<List<ProductReview>> getProductReviewByproductId(@RequestBody ProductReview productreview) {

        List<ProductReview> petReview = productReviewService.getProductReviewByproductId(productreview.getProductId());
        return ResponseEntity.ok(petReview);
    }
}

