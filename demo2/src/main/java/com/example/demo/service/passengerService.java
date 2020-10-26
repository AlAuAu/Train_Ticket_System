package com.example.demo.service;

import com.example.demo.entity.passenger;

public interface passengerService {
    void savePassenger(passenger passenger);
    passenger searchByCardID(String passenger_cardid);
    void deleteByID(String passenger_id);
}
