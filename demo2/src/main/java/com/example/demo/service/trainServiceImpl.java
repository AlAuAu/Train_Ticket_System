package com.example.demo.service;

import com.example.demo.dao.trainDAO;
import com.example.demo.entity.train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@Transactional
public class trainServiceImpl implements  trainService{
    @Autowired
    private trainDAO traindao;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public train searchByTrainID(String train_id){
        train trainDB=traindao.searchByTrainID(train_id);
        if(!ObjectUtils.isEmpty(trainDB)){
            return trainDB;
        }else {
            throw new RuntimeException("列车查询错误");
        }
    }
}
