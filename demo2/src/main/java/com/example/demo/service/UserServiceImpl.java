package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@Transactional

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User user){
        User userDB=userDAO.findByUserTel(user.getUser_tel());
        if(ObjectUtils.isEmpty(userDB)){
            userDAO.save(user.getUser_tel(),user.getUser_name(),user.getUser_id(),user.getUser_pwd());
        }else{
            throw new RuntimeException("用户名已存在！");
        }
    }

    @Override
    public User login(User user){
        //根据用户输入用户名进行查询
        User userDB=userDAO.findByUserTel(user.getUser_tel());
        if(!ObjectUtils.isEmpty(userDB)){
            //比较密码
            if(userDB.getUser_pwd().equals(user.getUser_pwd())){
                return userDB;
            }else {
                throw new RuntimeException("密码输入不正确！");
            }

        }else {
            throw new RuntimeException("用户名输入错误！");
        }
    }

    @Override
    public void edit(String user_tel,String user_pwd){
        try{
            userDAO.ChangePwdByID(user_tel,user_pwd);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
