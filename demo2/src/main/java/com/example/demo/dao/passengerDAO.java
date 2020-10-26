package com.example.demo.dao;

import com.example.demo.entity.passenger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Mapper
@Component
@Repository
public interface passengerDAO {
    void savePassenger(
      @Param("passenger_cardid") String passenger_cardid,
      @Param("passenger_name") String passenger_name,
      @Param("passenger_type") String passenger_type,
      @Param("passenger_tel") String passenger_tel,
      @Param("student_id") String student_id
    );
    passenger searchByCardID(@Param("passenger_cardid") String passenger_cardid);
    void deleteByID(@Param("passenger_id") String passenger_id);
}
