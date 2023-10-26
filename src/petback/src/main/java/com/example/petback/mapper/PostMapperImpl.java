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
        String sql = "INSERT INTO post (userId, postTitle, postContent, postImage) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, post.getUserId(), post.getPostTitle(), post.getPostContent(), post.getPostImage());
    }

    @Override
    public void updatePost(Post post) {
        String sql = "UPDATE post SET userId = ?, postTitle = ?, postContent = ?, postImage = ? WHERE postId = ?";
        jdbcTemplate.update(sql, post.getUserId(), post.getPostTitle(), post.getPostContent(), post.getPostImage(), post.getPostId());
    }

    @Override
    public void deletePost(Integer postId) {
        String sql = "DELETE FROM post WHERE postId = ?";
        jdbcTemplate.update(sql, postId);
    }
}