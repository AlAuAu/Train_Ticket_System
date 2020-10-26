package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@MapperScan("com.example.demo.mapper")
@MapperScan("com.example.demo.dao")
class trainServiceImplTest {
    @Autowired
    private  trainService trainservice;

    @Test
    void search(){
        System.out.println(trainservice.searchByTrainID("1"));
    }

}