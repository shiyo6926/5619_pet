package com.example.petback.controller;

import com.example.petback.entity.ProductReview;
import com.example.petback.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductReviewController {
    private final ProductReviewService productReviewService;

    @Autowired
    public ProductReviewController(ProductReviewService productReviewService) {
        this.productReviewService = productReviewService;
    }

    @PostMapping("/reviews")
    public void postReview(@RequestBody ProductReview review) {
        productReviewService.postReview(review);
    }
}

