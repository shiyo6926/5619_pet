package com.example.petback.mapper;

import com.example.petback.entity.Post;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface PostMapper {
    @Select("SELECT * FROM post")
    List<Post> getAllPosts();
    @Select("SELECT * FROM post WHERE postId = ?")
    Post getPostById(Integer postId);
    @Insert("INSERT INTO post (userName, userId, postTitle, postContent, postImage, postDate) VALUES (#{userName}, #{userId}, #{postTitle}, #{postContent}, #{postImage}, #{postDate})")
    void createPost(Post post);

    @Select("UPDATE post SET userName = ?, userId = ?, postTitle = ?, postContent = ?, postImage = ?, postDate = ? WHERE postId = ?")
   void updatePost(Post post);
    @Delete("DELETE FROM post WHERE postId = #{postId} AND userId = #{userId}")
    void deletePost(@Param("postId") Integer postId, @Param("userId") Integer userId);

}

/*
@Repository
public interface PostMapper {
    List<Post> getAllPosts();
    Post getPostById(Integer postId);
    void createPost(Post post);
    void updatePost(Post post);
    void deletePost(Integer postId, Integer userId);

}*/
