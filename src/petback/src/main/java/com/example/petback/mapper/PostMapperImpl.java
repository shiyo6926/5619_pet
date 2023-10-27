package com.example.petback.mapper;

import com.example.petback.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostMapperImpl implements PostMapper {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostMapperImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Post> getAllPosts() {
        String sql = "SELECT * FROM post";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public Post getPostById(Integer postId) {
        String sql = "SELECT * FROM post WHERE postId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{postId}, new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public void createPost(Post post) {
        String sql = "INSERT INTO post (userName, userId, postTitle, postContent, postImage, date) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, post.getUserName(), post.getUserId(), post.getPostTitle(), post.getPostContent(), post.getPostImage(), post.getDate());
    }

    @Override
    public void updatePost(Post post) {
        String sql = "UPDATE post SET userName = ?, userId = ?, postTitle = ?, postContent = ?, postImage = ?, date = ? WHERE postId = ?";
        jdbcTemplate.update(sql, post.getUserName(), post.getUserId(), post.getPostTitle(), post.getPostContent(), post.getPostImage(), post.getDate(), post.getPostId());
    }

    @Override
    public void deletePost(Integer postId, Integer userId) {
        String sql = "DELETE FROM post WHERE postId = ? AND userId = ?";
        jdbcTemplate.update(sql, postId, userId);
    }
}
