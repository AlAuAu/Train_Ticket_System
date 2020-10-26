package com.example.demo.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
@MapperScan("com.example.demo.dao")
class textServiceImplTest {

}