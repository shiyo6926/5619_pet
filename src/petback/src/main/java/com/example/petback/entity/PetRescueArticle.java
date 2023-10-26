package com.example.petback.entity;
import java.util.Date;

public class PetRescueArticle {
    private int id;
    private String title;
    private String content;

    private String author;

    public PetRescueArticle() {
        // 默认构造函数
    }

    public PetRescueArticle(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Getter and Setter methods

    public int  getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
