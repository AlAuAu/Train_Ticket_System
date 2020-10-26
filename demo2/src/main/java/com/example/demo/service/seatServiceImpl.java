package com.example.demo.service;

import com.example.demo.dao.seatDAO;
import com.example.demo.entity.orders;
import com.example.demo.entity.seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Transactional
public class seatServiceImpl implements  seatService {
    @Autowired
    private seatDAO  seatdao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<seat> searchSeat(orders orders){
        List<seat> seatList=seatdao.searchSeat(orders.getTrain_id(),orders.getTrain_date(),orders.getStart_stop_id(),orders.getEnd_stop_id(),orders.getSeat_type());
        if(!ObjectUtils.isEmpty(seatList)){
            System.out.println(seatList);
            return seatList;
        }else {
            throw new RuntimeException("没有余座");

        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public String searchID(seat seat){
        String seat_id=seatdao.searchID(seat.getTrain_id(),seat.getSeat_type(),seat.getSeat_location(),seat.getSeat_carriage());
        if(seat_id!=null){
            System.out.println(seat_id);
            return  seat_id;
        }else {
            throw  new RuntimeException("查询错误");
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public seat searchByIDs(String train_id,String seat_id){
        seat seatDB=seatdao.searchByIDs(train_id,seat_id);
            if(!ObjectUtils.isEmpty(seatDB)){
                return seatDB;
            }else {
                throw new RuntimeException("查询座位错误");
            }
        }


}
