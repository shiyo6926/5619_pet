package com.example.petback.mapper;
import com.example.petback.entity.Reply;
import java.util.List;

public interface ReplyDAO {
    Reply createReply(Reply reply);
    List<Reply> getRepliesByPostId(String postId);
}