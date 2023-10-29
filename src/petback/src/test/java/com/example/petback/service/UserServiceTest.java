package com.example.petback.service;

import com.example.petback.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;
    @BeforeEach
    void setUp() {

    }

    @Test
    void testSign_up() {
        //succuss
        User user1 =new User(null,"mimimi","222","cat","1234@cc.com","expert",0);
        //null
        User user2 =new User(null,null,"222","cat","1234@cc.com","expert",0);
        User user3 =new User(null,"mimimi",null,"cat","1234@cc.com","expert",0);
        User user4 =new User(null,"mimimi","222","cat",null,"expert",0);
        User user5 =new User(null,"mimimi","222","cat","1234@cc.com",null,0);
        //empty
        User user6 =new User(null,"","222","cat","1234@cc.com","expert",0);
        User user7 =new User(null,"mimimi","","cat","1234@cc.com","expert",0);
        User user8 =new User(null,"mimimi","222","cat","","expert",0);
        User user9 =new User(null,"mimimi","222","cat","1234@cc.com","",0);
        //repeat
        User user10 =new User(null,"mimi","222","cat","1234@cc.com","expert",0);
        User user11 =new User(null,"mimimimi","222","cat","156@qq.com","expert",0);
        System.out.println(userService.sign_up(user1));
        System.out.println(userService.sign_up(user2));
        System.out.println(userService.sign_up(user3));
        System.out.println(userService.sign_up(user4));
        System.out.println(userService.sign_up(user5));
        System.out.println(userService.sign_up(user6));
        System.out.println(userService.sign_up(user7));
        System.out.println(userService.sign_up(user8));
        System.out.println(userService.sign_up(user9));
        System.out.println(userService.sign_up(user10));
        System.out.println(userService.sign_up(user11));

    }

    @Test
    void testSign_in() {
        //success by username
        User user1 =new User(null,"mimi","222",null,null,null,1);
        //success by email
        User user2 =new User(null,null,"222",null,"234@qq.com",null,1);
        // no user
        User user3 =new User(null,"nouser","222",null,"nouser@qq.com",null,1);
        //password error
        User user4 =new User(null,"mimi","22222",null,null,null,1);
        User user5 =new User(null,null,"222222",null,"234@qq.com",null,1);
        System.out.println(userService.sign_in(user1));
        System.out.println(userService.sign_in(user2));
        System.out.println(userService.sign_in(user3));
        System.out.println(userService.sign_in(user4));
        System.out.println(userService.sign_in(user5));
    }

    @Test
    void testLog_state_check() {
        //success
        User user1 =new User(3790,null,null,null,null,null,1);
        //null
        User user2 =new User(null,null,null,null,null,null,1);
        // no this userId
        User user3 =new User(510,null,null,null,null,null,1);
        System.out.println(userService.log_state_check(user1));
        System.out.println(userService.log_state_check(user2));
        System.out.println(userService.log_state_check(user3));
    }

    @Test
    void testGet_userId_by_username() {
        //success
        User user1 =new User(null,"mimi",null,null,null,null,1);
        //null
        User user2 =new User(null,null,null,null,null,null,1);
        // no this username
        User user3 =new User(null,"nouser",null,null,null,null,1);
        System.out.println(userService.get_userId_by_username(user1));
        System.out.println(userService.get_userId_by_username(user2));
        System.out.println(userService.get_userId_by_username(user3));
    }

    @Test
    void testLog_out_state_update() {
        //success
        User user1 =new User(3790,null,null,null,null,null,0);
        //null
        User user2 =new User(null,null,null,null,null,null,0);
        // no this userId
        User user3 =new User(510,null,null,null,null,null,0);
        System.out.println(userService.log_out_state_update(user1));
        System.out.println(userService.log_out_state_update(user2));
        System.out.println(userService.log_out_state_update(user3));
    }
}