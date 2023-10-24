package com.example.petback.entity;

public class ProductReview {
    private int reviewId;
    private int userId;
    private int productId;
    private String reviewContent;
    private double rating;

    // Constructors, getters, and setters

    public ProductReview() {
    }

    public ProductReview(int reviewId, int userId, int productId, String reviewContent, double rating) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.productId = productId;
        this.reviewContent = reviewContent;
        this.rating = rating;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
