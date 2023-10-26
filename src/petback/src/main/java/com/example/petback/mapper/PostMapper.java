package com.example.petback.mapper;

import com.example.petback.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMapper {
    List<Post> getAllPosts();
    Post getPostById(Integer postId);
    void createPost(Post post);
    void updatePost(Post post);
    void deletePost(Integer postId, Integer userId);
}
