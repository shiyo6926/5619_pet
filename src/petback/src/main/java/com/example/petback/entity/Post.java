package com.example.petback.entity;

import java.util.Date;

public class Post {
    private Integer postId;
    private String userName;
    private Integer userId;
    private String postTitle;
    private String postContent;
    private String postImage;
    private String date;

    public Post() {
        // 默认构造函数
    }

    public Post(Integer postId, String userName, Integer userId, String postTitle, String postContent, String postImage, String date) {
        this.postId = postId;
        this.userName = userName;
        this.userId = userId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postImage = postImage;
        this.date = date;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userName='" + userName + '\'' +
                ", userId=" + userId +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postImage='" + postImage + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
