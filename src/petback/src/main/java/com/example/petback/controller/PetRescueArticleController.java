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
        String sql = "SELECT petRescueId,petRescueTitle FROM petrescue";
        List<Map<String, Object>> articles = jdbcTemplate.queryForList(sql);
        return articles;
    }
    @GetMapping("/articles/article1")
    public List<Map<String, Object>> getFirstArticles() {
        String sql = "SELECT petRescueTitle, petRescueContent, petRescueAuthor FROM petrescue where petRescueId=1";
        List<Map<String, Object>> articles = jdbcTemplate.queryForList(sql);
        return articles;
    }
    @GetMapping("/articles/article2")
    public List<Map<String, Object>> getSecondArticles() {
        String sql = "SELECT petRescueTitle, petRescueContent, petRescueAuthor FROM petrescue where petRescueId=2";
        List<Map<String, Object>> articles = jdbcTemplate.queryForList(sql);
        return articles;
    }
    @GetMapping("/articles/article3")
    public List<Map<String, Object>> getThirdArticles() {
        String sql = "SELECT petRescueTitle, petRescueContent, petRescueAuthor FROM petrescue where petRescueId=3";
        List<Map<String, Object>> articles = jdbcTemplate.queryForList(sql);
        return articles;
    }
    @GetMapping("/articles/article4")
    public List<Map<String, Object>> getForthArticles() {
        String sql = "SELECT petRescueTitle, petRescueContent, petRescueAuthor FROM petrescue where petRescueId=4";
        List<Map<String, Object>> articles = jdbcTemplate.queryForList(sql);
        return articles;
    }
    @GetMapping("/articles/article5")
    public List<Map<String, Object>> getFifthArticles() {
        String sql = "SELECT petRescueTitle, petRescueContent, petRescueAuthor FROM petrescue where petRescueId=5";
        List<Map<String, Object>> articles = jdbcTemplate.queryForList(sql);
        return articles;
    }
}
