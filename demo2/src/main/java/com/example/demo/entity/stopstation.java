package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class stopstation {
    String train_id;
    String stop_id;
    String city_name;
    String station_name;
    String arrival_time;
    String stop_time;
    String arrival_date;
}
