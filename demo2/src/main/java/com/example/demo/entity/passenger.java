package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class passenger {
    String passenger_id;
    String passenger_cardid;
    String passenger_name;
    String passenger_type;
    String passenger_tel;
    String student_id;
}
