package com.example.demo.dao;

import com.example.demo.entity.trainTransfer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
@Repository
public interface trainTransferDAO {
    List<trainTransfer> searchTransation(@Param("start_city_name") String start_city_name,
                                        @Param("end_city_name") String end_city_name,
                                        @Param("t1_start_date")  String t1_start_date);

}
