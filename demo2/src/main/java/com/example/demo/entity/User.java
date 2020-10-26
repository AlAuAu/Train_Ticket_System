package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String user_tel;
    private  String user_pwd;
    private  String user_name;
    private  String user_id;

}
