package com.example.demo.service;

import com.example.demo.config.ApplicationContextProvider;
import com.example.demo.entity.train;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dao.textDAO;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class textServiceImpl implements textService {
    @Autowired
    private textDAO textdao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<train> searchName(String train_id, String train_type) {

        List<train> trainDB = new ArrayList<>();
        trainDB = textdao.searchTrainName(train_id, train_type);
        if (!ObjectUtils.isEmpty(trainDB)) {
            return trainDB;
        } else {
            throw new RuntimeException("找不到列车信息");
        }


    }
}
