package com.example.petback.entity;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Post {
    private Integer postId;
    private String userName;
    private Integer userId;
    private String postTitle;
    private String postContent;
    private String postImage;
    private String postDate;

    public Post() {
        // 默认构造函数
    }

    public Post(Integer postId, String userName, Integer userId, String postTitle, String postContent, String postImage, String postDate) {
        this.postId = postId;
        this.userName = userName;
        this.userId = userId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postImage = postImage;
        this.postDate = postDate;
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

    public String getPostDate() {
        if (postDate == null) {
            return null; // 或者返回一个默认日期字符串，或者空字符串，取决于你的需求
        }

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        System.out.println("nmd/" + postDate);
        try {
            Date date = inputDateFormat.parse(postDate);
            System.out.println("postdate:"+postDate);
            System.out.println("date:"+date);

            System.out.println("format-date: " + outputDateFormat.format(date));
            return outputDateFormat.format(date); // 返回日期字符串，使用 "yyyy-MM-dd" 格式
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // 在日期解析失败时返回null
        }
    }

    public void setDate(String postDate) {
        this.postDate = postDate;
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
                ", postDate='" + postDate + '\'' +
                '}';
    }
}
