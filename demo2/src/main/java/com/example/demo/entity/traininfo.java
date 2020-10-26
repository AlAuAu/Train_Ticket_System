package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class traininfo {
    String train_id;
    String train_name;
    String train_type;
    String start_id;
    String end_id;
    String start_city_name;
    String end_city_name;
    String start_station_name;
    String end_station_name;
    String start_time;
    String end_time;
    String start_date;
}
