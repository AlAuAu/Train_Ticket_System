package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class orders {
    String order_id;
    String user_tel;
    String passenger_cardid;
    String train_id;
    String seat_id;
    String order_flag;
    String order_date;
    String start_stop_id;
    String end_stop_id;
    String train_date;
    String seat_type;

}
