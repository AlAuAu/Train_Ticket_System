package com.example.demo.dao;

import com.example.demo.entity.orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
@Repository
public interface ordersDAO {
    void saveOrders(

                    @Param("user_tel") String user_tel,
                    @Param("passenger_cardid") String passenger_cardid,
                    @Param("train_id") String train_id,
                    @Param("seat_id") String seat_id,
                    @Param("order_flag") String order_flag,
                    @Param("order_date") String order_date,
                    @Param("start_stop_id") String start_stop_id,
                    @Param("end_stop_id") String  end_stop_id,
                    @Param("train_date") String train_date,
                    @Param("seat_type")  String seat_type);
    List<orders> searchByUserTel(@Param("user_tel") String user_tel,@Param("order_flag") String order_flag);
    void deleteByID(@Param("order_id") String order_id );
    void changeOrderFlag(@Param("order_id") String order_id,@Param("order_flag") String order_flag);
    orders searchByID(@Param("order_id") String order_id);
}

