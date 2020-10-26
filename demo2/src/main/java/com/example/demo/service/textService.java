package com.example.demo.service;

import com.example.demo.entity.train;

import java.util.List;

public interface textService {
    List<train> searchName(String train_id,String train_type);
}
