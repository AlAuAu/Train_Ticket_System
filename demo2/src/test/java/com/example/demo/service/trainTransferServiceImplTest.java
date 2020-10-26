package com.example.demo.service;

import com.example.demo.entity.trainTransfer;
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
class trainTransferServiceImplTest {
    @Autowired
    private  trainTransferService traintransferService;
    @Test
    void search(){
        trainTransfer traintransfer=new trainTransfer("","2020-10-12","","","","","","","","","","","","济南","广州","","");
        List<trainTransfer> traininfoDB= new ArrayList<>();
        traininfoDB=traintransferService.searchTransation(traintransfer);
        System.out.println(traininfoDB);
    }

}