package com.example.demo.service;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
@MapperScan("com.example.demo.dao")
class UserServiceTest {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Test
    void  login(){
        User user=new User("123","123","李四","123");
        System.out.println(userServiceImpl.login(user));
    }




}