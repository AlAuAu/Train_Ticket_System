package com.example.demo.dao;

import com.example.demo.entity.traininfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
@Repository
public interface traininfoDAO {
    List<traininfo> searchTrainInfo(
                              @Param("start_city_name") String start_city_name,
                              @Param("end_city_name") String end_city_name,
                              @Param("start_date")  String start_date);
   List<traininfo> changeTrainInfo(@Param("start_city_name") String start_city_name,
                                   @Param("end_city_name") String end_city_name,
                                   @Param("start_date")  String start_date);
}
