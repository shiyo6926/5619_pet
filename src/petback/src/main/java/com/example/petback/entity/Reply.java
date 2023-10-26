package com.example.petback.entity;

public class Reply {
    private Integer replyId;
    private Integer userId;
    private String postId;
    private String replyContent;


    public Reply() {
        // 默认无参构造函数
    }

    public Reply(Integer userId, String postId, String replyContent) {
        this.userId = userId;
        this.postId = postId;
        this.replyContent = replyContent;
    }

    public Integer getId() {
        return replyId;
    }

    public void setId(Integer id) {
        this.replyId = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }


}