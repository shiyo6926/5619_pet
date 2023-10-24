package com.example.petback.entity;

public class PetProduct {
    private int productId;
    private int userId;
    private String productName;
    private String tag;
    private String productInformation;
    private String reason;

    public PetProduct() {
    }

    public PetProduct(int productId, int userId, String productName, String tag, String productInformation, String reason) {
        this.productId = productId;
        this.userId = userId;
        this.productName = productName;
        this.tag = tag;
        this.productInformation = productInformation;
        this.reason = reason;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }
}

