package com.example.petback.entity;

public class PetDiary {
    public PetDiary() {
    }

    public PetDiary(int petDiaryId, int userId, String date, String value, String reason) {
        this.petDiaryId = petDiaryId;
        this.userId = userId;
        this.value = value;
        this.date = date;
        this.petDiaryId = petDiaryId;
        this.reason = reason;
    }

    public int getPetDiaryId() {
        return petDiaryId;
    }

    public void setpetDiaryId(int petDiaryId) {
        this.petDiaryId = petDiaryId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private int petDiaryId;
    private String date;
    private int userId;
    private String value;
    private String reason;
}


