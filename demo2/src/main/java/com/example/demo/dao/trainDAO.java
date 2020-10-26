package com.example.demo.dao;

import com.example.demo.entity.train;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Component
@Repository
public interface trainDAO {
    train searchByTrainID(String train_id);
}
