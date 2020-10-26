package com.example.demo.service;

import com.example.demo.entity.orders;

import java.util.List;

public interface ordersService {
    void buyTicket(orders orders);
    List<orders> getOrders(String user_tel,String order_flag);
    void deleteByID(String order_id);
    void changeOrderFlag(String order_id,String order_flag);
    orders searchByID(String order_id);
}
