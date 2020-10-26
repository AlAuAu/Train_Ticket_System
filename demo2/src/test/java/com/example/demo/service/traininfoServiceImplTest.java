package com.example.demo.service;

import com.example.demo.entity.traininfo;
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
class traininfoServiceImplTest {
    @Autowired
    private  traininfoService train_infoService;
    @Test
    void search(){
        traininfo train_info=new traininfo("1","G1","高铁","0","2","北京","上海","北京南站","上海西站","2020-10-13","2020-10-14","2020-10-13");
        List<traininfo> traininfoDB= new ArrayList<>();
        traininfoDB=train_infoService.search(train_info);
        System.out.println(traininfoDB);
    }

}