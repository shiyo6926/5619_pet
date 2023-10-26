package com.example.petback.entity;

import java.util.Date;

public class PetRescue {
    private User creator;
    private String rescueName;
    private String rescueDescription;
    private Date date;
    private String location;

    public PetRescue() {
        // 默认构造函数
    }

    public PetRescue(User creator, String rescueName, String rescueDescription, Date date, String location) {
        this.creator = creator;
        this.rescueName = rescueName;
        this.rescueDescription = rescueDescription;
        this.date = date;
        this.location = location;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getRescueName() {
        return rescueName;
    }

    public void setRescueName(String rescueName) {
        this.rescueName = rescueName;
    }

    public String getRescueDescription() {
        return rescueDescription;
    }

    public void setRescueDescription(String rescueDescription) {
        this.rescueDescription = rescueDescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
