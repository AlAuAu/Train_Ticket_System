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
class ordersServiceImplTest {
    @Autowired
    private  ordersServiceImpl ordersServiceimpl;

    @Test
    void buyTicket(){
        orders orders=new orders("","123","123456","1","0","已支付","2020-10-11 11:00:00","0","2","2020-10-12","二等座");
        ordersServiceimpl.buyTicket(orders);

    }

    @Test
    void searchByUserTel(){
        String user_tel="123";
        String order_flag="未支付";
        System.out.println(ordersServiceimpl.getOrders(user_tel,order_flag));
    }

    @Test
    void delete(){
        ordersServiceimpl.deleteByID("1");
    }

}