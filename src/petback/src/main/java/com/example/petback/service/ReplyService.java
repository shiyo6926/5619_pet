package com.example.petback.service;
import com.example.petback.entity.Reply;
import com.example.petback.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
    private final ReplyMapper replyMapper;

    @Autowired
    public ReplyService(ReplyMapper replyMapper) {
        this.replyMapper = replyMapper;
    }

    public void createReply(Reply reply) {
        replyMapper.createReply(reply);
    }

    public List<Reply> getRepliesByPostId(String postId) {
        return replyMapper.getRepliesByPostId(postId);
    }
}