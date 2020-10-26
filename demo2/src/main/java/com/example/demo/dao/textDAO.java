package com.example.demo.dao;

import com.example.demo.entity.train;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//用来创建DAO对象
@Component
@Repository
public interface textDAO {
    List<train> searchTrainName(
            @Param("train_id") String train_id,
            @Param("train_type") String train_type);

}

