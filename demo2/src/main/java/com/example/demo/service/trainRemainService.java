package com.example.demo.service;

import com.example.demo.entity.trainRemain;

import java.util.List;

public interface trainRemainService {
    List<trainRemain> count_Ticket(String train_id,String train_date,String start_stop_id,String end_stop_id);
}
