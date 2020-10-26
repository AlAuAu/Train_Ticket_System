package com.example.demo.service;

import com.example.demo.dao.passengerDAO;
import com.example.demo.dao.seatDAO;
import com.example.demo.dao.stopstationDAO;
import com.example.demo.dao.trainDAO;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class orderServiceImpl implements  orderService {
    @Autowired
    private trainService trainservice;
    @Autowired
    private stopstationService stopstationservice;
    @Autowired
    private seatService seatservice;
    @Autowired
    private passengerService passengerservice;



    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public order constructOrder(orders orders){
            System.out.println("执行一次Construction");
            train trainDB=trainservice.searchByTrainID(orders.getTrain_id());
            seat seatDB=seatservice.searchByIDs(orders.getTrain_id(),orders.getSeat_id());
            passenger passengerDB=passengerservice.searchByCardID(orders.getPassenger_cardid());
            stopstation start_station=stopstationservice.searchByIDs(orders.getTrain_id(),orders.getStart_stop_id());
            stopstation stop_station=stopstationservice.searchByIDs(orders.getTrain_id(),orders.getEnd_stop_id());
            order order=new order(orders.getOrder_id(),orders.getOrder_flag(),passengerDB.getPassenger_name(),passengerDB.getPassenger_id(),trainDB.getTrian_name(),start_station.getCity_name(),stop_station.getCity_name(),start_station.getStation_name(),stop_station.getStation_name(),start_station.getArrival_date(),start_station.getArrival_time(),seatDB.getSeat_type(),seatDB.getSeat_price(),seatDB.getSeat_location(),seatDB.getSeat_carriage(),orders.getOrder_date());
            return order;
    }


}
