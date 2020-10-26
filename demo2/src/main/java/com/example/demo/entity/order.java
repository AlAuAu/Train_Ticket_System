package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class order {
    String order_id;
    String order_flag;
    String passenger_name;
    String passenger_id;
    String train_name;
    String start_city_name;
    String end_city_name;
    String start_stop_name;
    String end_stop_name;
    String start_date;
    String start_time;
    String seat_type;
    String seat_price;
    String seat_location;
    String seat_carriage;
    String order_time;
}
