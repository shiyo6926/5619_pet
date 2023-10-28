package com.example.petback.controller;

import com.example.petback.entity.Post;
import com.example.petback.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

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
        System.out.println("there date"+posts.get(0).getPostDate());
        posts.get(0).getPostDate();
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
    @DeleteMapping("/deletePost")
    public ResponseEntity<Void> deletePost(@RequestBody Map<String, Object> requestBody) {
        Integer postId = (Integer) requestBody.get("postId");
        Integer userId = (Integer) requestBody.get("userId");

        if (postId != null && userId != null) {
            postMapper.deletePost(postId, userId);
            return ResponseEntity.noContent().build();
        } else {
            // 处理无效输入的逻辑，例如返回错误响应
            return ResponseEntity.badRequest().build();
        }
    }

    /*@DeleteMapping("/deletePost/{postId}/{userId}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer postId, @PathVariable Integer userId) {
        postMapper.deletePost(postId, userId);
        return ResponseEntity.noContent().build();
    }*/
}
