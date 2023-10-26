package com.example.petback.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PetRescueArticleController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PetRescueArticleController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/articles")
    public List<Map<String, Object>> getAllArticles() {
        String sql = "SELECT title, content, author FROM pet_rescue_articles";
        List<Map<String, Object>> articles = jdbcTemplate.queryForList(sql);
        return articles;
    }
}
