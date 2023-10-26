package com.example.petback.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.example.petback.entity.Reply;

import java.util.List;
import org.apache.ibatis.annotations.*;


@Mapper
public interface ReplyMapper {
    @Insert("INSERT INTO reply (userId, postId, replyContent) VALUES (#{userId}, #{postId}, #{replyContent})")

    //@Options(useGeneratedKeys = true, keyProperty = "Rid")
    void createReply(Reply reply);

    @Select("SELECT * FROM reply WHERE postId = #{postId}")
    List<Reply> getRepliesByPostId(String postId);
}