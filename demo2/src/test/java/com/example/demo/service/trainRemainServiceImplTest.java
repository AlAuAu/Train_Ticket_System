package com.example.demo.service;

import com.example.demo.entity.trainRemain;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
@MapperScan("com.example.demo.dao")

class trainRemainServiceImplTest {
    @Autowired
    private  trainRemainService trainremainService;
    @Test
    void count(){
        List<trainRemain> trainRemainDB= new ArrayList<>();
        trainRemainDB=trainremainService.count_Ticket("1","2020-10-12","0","2");
        System.out.println(trainRemainDB);
    }

}