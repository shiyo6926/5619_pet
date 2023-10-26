package com.example.petback.service;

import com.example.petback.entity.Post;
import com.example.petback.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostMapper postMapper;

    @Autowired
    public PostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public List<Post> getAllPosts() {
        return postMapper.getAllPosts();
    }

    public Post getPostById(Post post) {
        return postMapper.getPostById(post.getPostId());
    }

    public void createPost(Post post) {
        postMapper.createPost(post);
    }

    public void updatePost(Post post) {
        postMapper.updatePost(post);
    }

    public void deletePost(Integer postId) {
        postMapper.deletePost(postId);
    }
}
