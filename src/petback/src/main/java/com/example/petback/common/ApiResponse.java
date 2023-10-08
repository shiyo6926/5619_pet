package com.example.petback.common;

public class ApiResponse {
    private boolean registered_pet_success;
    private String registered_pet_false_reason;
    private String registered_pet_false_type;
    private String petID;

    public ApiResponse(boolean registered_pet_success, String registered_pet_false_reason, String registered_pet_false_type, String petID) {
        this.registered_pet_success = registered_pet_success;
        this.registered_pet_false_reason = registered_pet_false_reason;
        this.registered_pet_false_type = registered_pet_false_type;
        this.petID = petID;
    }

    public boolean isRegistered_pet_success() {
        return registered_pet_success;
    }

    public void setRegistered_pet_success(boolean registered_pet_success) {
        this.registered_pet_success = registered_pet_success;
    }

    public String getRegistered_pet_false_reason() {
        return registered_pet_false_reason;
    }

    public void setRegistered_pet_false_reason(String registered_pet_false_reason) {
        this.registered_pet_false_reason = registered_pet_false_reason;
    }

    public String getRegistered_pet_false_type() {
        return registered_pet_false_type;
    }

    public void setRegistered_pet_false_type(String registered_pet_false_type) {
        this.registered_pet_false_type = registered_pet_false_type;
    }

    public String getPetID() {
        return petID;
    }

    public void setPetID(String petID) {
        this.petID = petID;
    }
}
