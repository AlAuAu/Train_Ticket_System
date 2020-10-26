package com.example.demo.service;

import com.example.demo.config.ApplicationContextProvider;
import com.example.demo.dao.trainTransferDAO;
import com.example.demo.entity.trainTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class trainTransferServiceImpl implements trainTransferService {
    @Autowired
    private trainTransferDAO traintransferdao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<trainTransfer> searchTransation(trainTransfer traintransfer){
        traintransferdao = ApplicationContextProvider.getBean(trainTransferDAO.class);
        List<trainTransfer> trainTransferDB=new ArrayList<>();
        trainTransferDB=traintransferdao.searchTransation(traintransfer.getStart_city_name(),traintransfer.getEnd_city_name(),traintransfer.getT1_start_date());
        System.out.println("train_infoDB:"+trainTransferDB);
        if(!ObjectUtils.isEmpty(trainTransferDB)){
            return  trainTransferDB;
        }else {
            throw new RuntimeException("找不到列车信息");
        }

    }


}
