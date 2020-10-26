package com.example.demo.service;

import com.example.demo.dao.stopstationDAO;
import com.example.demo.entity.stopstation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@Transactional
public class stopstationServiceImpl implements  stopstationService {
    @Autowired
    private stopstationDAO stopstationdao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public stopstation searchByIDs(String train_id,String stop_id){
        stopstation stopstationDB=stopstationdao.searchByIDs(train_id,stop_id);
        if(!ObjectUtils.isEmpty(stopstationDB)){
            return  stopstationDB;
        }else {
            throw new RuntimeException("查询车站错误");
        }
    }

}
