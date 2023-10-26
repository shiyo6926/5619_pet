package com.example.petback.entity;

public class Adoption {
    private int creatorID;
    private int adoptorID;
    private String petName;
    private String tag;
    private int age;
    private String gender;
    private String adoptionStatus;

    public Adoption() {
        // 默认构造函数
    }

    public Adoption(int creatorID, int adoptorID, String petName, String tag, int age, String gender, String adoptionStatus) {
        this.creatorID = creatorID;
        this.adoptorID = adoptorID;
        this.petName = petName;
        this.tag = tag;
        this.age = age;
        this.gender = gender;
        this.adoptionStatus = adoptionStatus;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }

    public int getAdoptorID() {
        return adoptorID;
    }

    public void setAdoptorID(int adoptorID) {
        this.adoptorID = adoptorID;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(String adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }
}
