package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Mapper//用来创建DAO对象
@Component
@Repository
public interface UserDAO {
    void save(@Param("user_tel") String user_tel,@Param("user_name") String user_name,@Param("user_id") String user_id,@Param("user_pwd" )String user_pwd);
    User findByUserTel(@Param("user_tel") String user_tel);
    void ChangePwdByID(@Param("user_tel") String user_tel,@Param("user_pwd") String user_pwd);
}
