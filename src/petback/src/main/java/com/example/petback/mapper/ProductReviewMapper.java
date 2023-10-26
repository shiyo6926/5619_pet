package com.example.petback.mapper;

import com.example.petback.entity.ProductReview;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductReviewMapper {
    @Options(useGeneratedKeys = true, keyProperty = "reviewId")
    void insertProductReview(ProductReview productReview);
    @Insert("INSERT INTO productreview (productId, userId, reviewContent) VALUES (#{productId}, #{userId}, #{reviewContent})")
    void addProductReview(ProductReview productReview);
    @Select("SELECT * FROM productreview WHERE userId = #{userId} AND productId=#{productId} AND reviewContent = #{reviewContent}")
    List<ProductReview> getProductReviewList(ProductReview productReview);
    @Update("UPDATE productreview SET productId = #{productId}, reviewContent = #{reviewContent} WHERE reviewId = #{reviewId}")
    void updateProductReview(ProductReview productReview);

    @Delete("DELETE FROM productreview WHERE reviewId = #{reviewId} AND userId = #{userId}")
    void deleteProductReview(ProductReview productReview);

    @Select("SELECT * FROM productreview WHERE productId = #{productId}")
    List<ProductReview> getProductReviewByproductId(int productId);

}

