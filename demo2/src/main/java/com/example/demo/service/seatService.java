package com.example.demo.service;

import com.example.demo.entity.orders;
import com.example.demo.entity.seat;

import java.util.List;

public interface seatService {
    List<seat> searchSeat(orders orders);
    String searchID(seat seat);
    seat searchByIDs(String train_id,String seat_id);
}
