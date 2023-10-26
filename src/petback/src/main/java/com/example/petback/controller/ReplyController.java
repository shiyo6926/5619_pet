package com.example.petback.controller;
import com.example.petback.entity.Reply;
import com.example.petback.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/replies")
public class ReplyController {
    private final ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createReply(@RequestBody Reply reply) {
        System.out.println(reply.getUserId());
        try {
            replyService.createReply(reply);
            return ResponseEntity.ok("Reply created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create reply.");
        }
    }

    @GetMapping("/getRepliesByPostId/{postId}")
    public List<Reply> getRepliesByPostId(@PathVariable String postId) {
        return replyService.getRepliesByPostId(postId);
    }
}
