package com.example.petback.mapper;

import com.example.petback.entity.ProductReview;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface ProductReviewMapper {
    @Insert("INSERT INTO product_review (user_id, product_id, review_content, rating) " +
            "VALUES (#{userId}, #{productId}, #{reviewContent}, #{rating})")
    @Options(useGeneratedKeys = true, keyProperty = "reviewId")
    void insertProductReview(ProductReview review);
}

