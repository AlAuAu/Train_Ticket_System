package com.example.demo.dao;

import com.example.demo.entity.seat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
@Repository
public interface seatDAO {
    List<seat> searchSeat(@Param("train_id") String train_id,@Param("train_date") String train_date,@Param("start_stop_id") String start_stop_id,@Param("end_stop_id") String end_stop_id,@Param("seat_type") String seat_type);
    String searchID(@Param("train_id") String train_id,@Param("seat_type") String seat_type,@Param("seat_location") String seat_location,@Param("seat_carriage") String seat_carriage);
    seat searchByIDs(@Param("train_id") String train_id,@Param("seat_id") String seat_id);
}
