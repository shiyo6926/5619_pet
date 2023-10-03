package com.example.petback.controller;
import com.example.petback.entity.User;
import com.example.petback.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import  org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign_in")
public class signinController {
    @Autowired
    private UserMapper userMapper;
    @PostMapping
    public int save(@RequestBody User user) {
        return userMapper.sign_in(user);

    }
}
