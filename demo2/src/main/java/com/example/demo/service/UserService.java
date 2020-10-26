package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    //用户注册
    void register(User user);

    //用户登录
    User login(User user);

    //用户修改信息
    void edit(String user_tel,String user_pwd);
}

