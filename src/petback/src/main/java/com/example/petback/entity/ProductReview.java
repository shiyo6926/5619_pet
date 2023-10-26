package com.example.petback.entity;

public class ProductReview {
    private int reviewId;
    private int userId;
    private int productId;
    private String reviewContent;
    private String reason;

    // Constructors, getters, and setters

    public ProductReview() {
    }

    public ProductReview(int reviewId, int userId, int productId, String reviewContent) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.productId = productId;
        this.reviewContent = reviewContent;
        this.reason = reason;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
