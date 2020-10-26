package com.example.demo.service;

import com.example.demo.entity.orders;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
@MapperScan("com.example.demo.dao")
class orderServiceImplTest {
    @Autowired
    private orderService orderservice;

    @Test
    void test(){
        orders orders=new orders("2","123","123456","1","2","已支付","2020/10/18 下午8:02:15","0","2","2020-10-12","一等座");
        System.out.println(orderservice.constructOrder(orders));
    }

}