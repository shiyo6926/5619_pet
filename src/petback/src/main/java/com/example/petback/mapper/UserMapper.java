package com.example.petback.mapper;

import com.example.petback.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user(userID,userName,password,pet,email,userType) VALUES (#{userID},#{userName},#{password},#{pet},#{email},#{userType})")
    int sign_in(User user);
    @Select("Select * from user")
    List<User> select();
}
