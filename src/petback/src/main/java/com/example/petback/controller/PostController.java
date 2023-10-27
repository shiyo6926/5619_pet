package com.example.petback.controller;

import com.example.petback.entity.Post;
import com.example.petback.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostMapper postMapper;

    @Autowired
    public PostController(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @GetMapping("/getAllPosts")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postMapper.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/getPostById/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer postId) {
        Post post = postMapper.getPostById(postId);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/createPost")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        postMapper.createPost(post);
        return ResponseEntity.ok(post);
    }

    @PutMapping("/updatePost")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        postMapper.updatePost(post);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/deletePost/{postId}/{userId}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer postId, @PathVariable Integer userId) {
        postMapper.deletePost(postId, userId);
        return ResponseEntity.noContent().build();
    }
}
