package com.example.demo.service;

import com.example.demo.config.ApplicationContextProvider;
import com.example.demo.dao.traininfoDAO;
import com.example.demo.entity.traininfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class traininfoServiceImpl implements traininfoService {
    @Autowired
    private traininfoDAO train_infoDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<traininfo> search(traininfo train_info){
            train_infoDAO = ApplicationContextProvider.getBean(traininfoDAO.class);
            List<traininfo> train_infoDB=new ArrayList<>();
            train_infoDB=train_infoDAO.searchTrainInfo(train_info.getStart_city_name(),train_info.getEnd_city_name(),train_info.getStart_date());
            System.out.println("train_infoDB:"+train_infoDB);
            if(!ObjectUtils.isEmpty(train_infoDB)){
                return  train_infoDB;
            }else {
                throw new RuntimeException("找不到列车信息");
            }


    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public  List<traininfo> changeTrainInfo(String  start_city_name,String end_city_name, String start_date){
        List<traininfo> train_infoDB=new ArrayList<>();
        train_infoDB=train_infoDAO.changeTrainInfo(start_city_name,end_city_name,start_date);
        System.out.println("train_infoDB:"+train_infoDB);
        if(!ObjectUtils.isEmpty(train_infoDB)){
            return  train_infoDB;
        }else {
            throw new RuntimeException("找不到列车信息");
        }
    }


}
