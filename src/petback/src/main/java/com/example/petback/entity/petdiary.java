package com.example.petback.entity;

public class petdiary {
    private Integer petId;
    private String pet;
    private String value;
    private String date;
    public petdiary() {
        // 无参构造函数
    }

    public petdiary(Integer PetID, String value, String date) {
        this.value = value;
        this.date = date;
    }

    // Getter和Setter方法
    public Integer getId() {
        return userID;
    }

    public void setId(Integer userID) {
        this.userID = userID;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    // 其他业务逻辑方法
}

