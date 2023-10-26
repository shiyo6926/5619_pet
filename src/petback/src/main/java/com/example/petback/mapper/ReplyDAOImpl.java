package com.example.petback.mapper;
import com.example.petback.entity.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReplyDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Reply createReply(Reply reply) {
        String sql = "INSERT INTO reply (userId, postId, replyContent) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, reply.getUserId(), reply.getPostId(), reply.getReplyContent());
        return reply;
    }

    @Override
    public List<Reply> getRepliesByPostId(String postId) {
        String sql = "SELECT * FROM reply WHERE postId = ?";
        return jdbcTemplate.query(sql, new Object[]{postId}, (rs, rowNum) -> {
            Reply reply = new Reply();
            reply.setId(rs.getInt("id"));
            reply.setUserId(rs.getInt("userId"));
            reply.setPostId(rs.getString("postId"));
            reply.setReplyContent(rs.getString("replyContent"));
            return reply;
        });
    }
}
