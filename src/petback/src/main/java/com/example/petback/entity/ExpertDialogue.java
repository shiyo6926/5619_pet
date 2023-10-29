package com.example.petback.entity;

public class ExpertDialogue {
    private Integer expertDialogueId;
    private Integer userId;

    public ExpertDialogue(Integer expertDialogueId, Integer userId, Integer expertId, String info) {
        this.expertDialogueId = expertDialogueId;
        this.userId = userId;
        this.expertId = expertId;
        this.info = info;
    }

    private Integer expertId;
    private String info;

    public Integer getExpertDialogueId() {
        return expertDialogueId;
    }

    public void setExpertDialogueId(Integer expertDialogueId) {
        this.expertDialogueId = expertDialogueId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getExpertId() {
        return expertId;
    }

    public void setExpertId(Integer expertId) {
        this.expertId = expertId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
