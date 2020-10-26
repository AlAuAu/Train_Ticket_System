package com.example.demo.dao;

import com.example.demo.entity.stopstation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Component
@Repository
public interface stopstationDAO {
    stopstation searchByIDs(@Param("train_id") String train_id,@Param("stop_id") String stop_id);
}
