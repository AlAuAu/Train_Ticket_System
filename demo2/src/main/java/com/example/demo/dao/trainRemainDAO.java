package com.example.demo.dao;

import com.example.demo.entity.trainRemain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
@Repository
public interface trainRemainDAO {
    List<trainRemain> countTicket(@Param("train_id") String train_id,@Param("train_date") String train_date,@Param("start_stop_id") String start_stop_id,@Param("end_stop_id") String end_stop_id);
}
