package com.example.petback.entity;
public class User
{
    private Integer userID;
    private String userName;
    private String password;
    private String pet;
    private String email;
    private String userType;

    public Integer getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
    public boolean success(){
        return true;
    }
}
