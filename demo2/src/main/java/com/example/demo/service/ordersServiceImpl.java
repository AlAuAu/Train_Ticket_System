package com.example.demo.service;

import com.example.demo.dao.ordersDAO;
import com.example.demo.entity.orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Transactional
public class ordersServiceImpl implements  ordersService {
    @Autowired
    private ordersDAO ordersdao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void buyTicket(orders orders) {
        try {
            System.out.println(orders);
            ordersdao.saveOrders(orders.getUser_tel(),orders.getPassenger_cardid(),orders.getTrain_id(),orders.getSeat_id(),orders.getOrder_flag(),orders.getOrder_date(),orders.getStart_stop_id(),orders.getEnd_stop_id(),orders.getTrain_date(),orders.getSeat_type());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<orders> getOrders(String user_tel,String order_flag) {

        List<orders> ordersList = ordersdao.searchByUserTel(user_tel, order_flag);
        if(!ObjectUtils.isEmpty(ordersList)){
            System.out.println(ordersList);
            return ordersList;
        }else {
            throw  new RuntimeException("查询错误");
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteByID(String order_id){
        try{
            System.out.println("order_id:"+order_id);
            ordersdao.deleteByID(order_id);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void changeOrderFlag(String order_id,String order_flag){
        try {
            ordersdao.changeOrderFlag(order_id,order_flag);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public  orders searchByID(String order_id){
        orders ordersDB=ordersdao.searchByID(order_id);
        if(!ObjectUtils.isEmpty(ordersDB)){
            return  ordersDB;
        }else {
            throw  new RuntimeException("查询订单错误");
        }
    }





}
