package com.example.demo.service;

import com.example.demo.dao.passengerDAO;
import com.example.demo.entity.orders;
import com.example.demo.entity.passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@Transactional
public class passengerServiceImpl implements  passengerService {
    @Autowired
    private passengerDAO passengerdao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void savePassenger(passenger passenger) {
        try {
            System.out.println(passenger);
            passengerdao.savePassenger(passenger.getPassenger_cardid(),passenger.getPassenger_name(),passenger.getPassenger_type(),passenger.getPassenger_tel(),passenger.getStudent_id());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public  passenger searchByCardID(String passenger_cardid){
        passenger passengerDB=passengerdao.searchByCardID(passenger_cardid);
        if(!ObjectUtils.isEmpty(passengerDB)){
            return passengerDB;
        }else {
            throw new RuntimeException("查询失败");
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void  deleteByID(String passenger_id){
        try{
            passengerdao.deleteByID(passenger_id);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
