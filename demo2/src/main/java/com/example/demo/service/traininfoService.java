package com.example.demo.service;

import com.example.demo.entity.traininfo;

import java.util.List;

public interface traininfoService {
    List<traininfo> search(traininfo train_info);
    List<traininfo> changeTrainInfo(String  start_city_name,String end_city_name, String start_date);
}
