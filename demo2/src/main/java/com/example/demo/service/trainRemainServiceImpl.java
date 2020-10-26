package com.example.demo.service;

import com.example.demo.dao.trainRemainDAO;
import com.example.demo.entity.trainRemain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Transactional
public class trainRemainServiceImpl implements  trainRemainService{
    @Autowired
    private trainRemainDAO trainremaindao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<trainRemain> count_Ticket(String train_id,String train_date,String start_stop_id,String end_stop_id){
        List<trainRemain> trainRemainDB=trainremaindao.countTicket(train_id,train_date,start_stop_id,end_stop_id);
        if (!ObjectUtils.isEmpty(trainRemainDB)) {
            System.out.println(trainRemainDB);
            return trainRemainDB;
        }else {
            throw new RuntimeException("找不到信息，出错");
        }
    }
}
