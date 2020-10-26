package com.example.demo.service;

import com.example.demo.entity.orders;
import com.example.demo.entity.seat;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
@MapperScan("com.example.demo.dao")
class seatServiceImplTest {
    @Autowired
    private seatService seatservice;

    @Test
    public  void  searchSeat(){
        orders orders=new orders("","123","123456","1","0","已支付","2020-10-11 11:00:00","0","2","2020-10-12","二等座");
        System.out.println(seatservice.searchSeat(orders));
    }

    @Test
    public  void searchID(){
         seat seat=new seat("1","","一等座","01B","","1");
         System.out.println("train_id:"+seatservice.searchID(seat));
    }

    @Test
    public void searchByIDs(){
        System.out.println(seatservice.searchByIDs("1","1"));
    }

}