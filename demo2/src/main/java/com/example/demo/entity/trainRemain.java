package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class trainRemain {
    String train_id;
    String train_name;
    String seat_type;
    String seat_count;
    String seat_price;

}
