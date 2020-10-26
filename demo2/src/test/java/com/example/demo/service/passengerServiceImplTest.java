package com.example.demo.service;

import com.example.demo.entity.passenger;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
@MapperScan("com.example.demo.dao")

class passengerServiceImplTest {
    @Autowired
    private  passengerService passengerservice;

    @Test
    void addPassenger(){
        passenger passenger=new passenger("","123456","李四","成人","123456","");
        passengerservice.savePassenger(passenger);

    }

    @Test
   void searchByID(){

        System.out.println(passengerservice.searchByCardID("123456"));
    }

}