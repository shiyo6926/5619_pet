package com.example.petback.service;

import com.example.petback.entity.ProductReview;
import com.example.petback.mapper.ProductReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductReviewService {
    private final ProductReviewMapper productReviewMapper;

    @Autowired
    public ProductReviewService(ProductReviewMapper productReviewMapper) {
        this.productReviewMapper = productReviewMapper;
    }

    public void postReview(ProductReview review) {
        productReviewMapper.insertProductReview(review);
    }
}

