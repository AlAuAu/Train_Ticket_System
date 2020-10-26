package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class trainTransfer {
    String t1_train_id;
    String t1_start_date;
    String t1_start_stop_id;
    String t1_end_stop_id;
    String t2_train_id;
    String t2_start_date;
    String t2_start_stop_id;
    String t2_end_stop_id;
    String start_time;
    String start_station_name;
    String transfer_station;
    String end_station_name;
    String end_time;
    String start_city_name;
    String end_city_name;
    String train_name1;
    String train_name2;
}
