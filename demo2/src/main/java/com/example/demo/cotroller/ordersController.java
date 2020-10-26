package com.example.demo.cotroller;

import com.example.demo.entity.order;
import com.example.demo.entity.orders;
import com.example.demo.service.orderService;
import com.example.demo.service.ordersService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orders")
@Slf4j
@CrossOrigin
@RestController
public class ordersController {
    @Autowired
    private ordersService ordersservice;
    @Autowired
    private orderService orderservice;

    /*
     * 处理购票
     */
    @RequestMapping("buyTicket")
    public Map<String,Object> buyTicket(@RequestBody orders orders){
        Map<String,Object> map=new HashMap<>();
        try{
            ordersservice.buyTicket(orders);
            map.put("state",true);
            map.put("msg","购票成功!");
        }catch (Exception e){
            map.put("state",false);
            map.put("msg",e);
        }
        return map;
    }

    /**
     * 获取订单具体信息的列表
     * */
    @RequestMapping("searchOrderList")
    public Map<String,Object> searchOrderList(@RequestBody Map<String,Object> datas){
        Map<String,Object> map =new HashMap<>();
        System.out.println((String) datas.get("user_tel"));
        try{
            List<orders> ordersList=ordersservice.getOrders((String) datas.get("user_tel"),(String) datas.get("order_flag"));
            List<order> orderList=new ArrayList<>();
            for(int i=0;i<ordersList.size();i++){
                System.out.println("执行一次构建具体订单列表");
                System.out.println(ordersList.get(i));
                order _order=orderservice.constructOrder(ordersList.get(i));
                System.out.println(_order);
                orderList.add(_order);
            }
            map.put("state",true);
            map.put("msg","查询订单具体信息列表成功!");
            map.put("ordersList",orderList);
        }catch (Exception e){
            map.put("state",false);
            map.put("msg","查询订单具体信息列表失败!");
            map.put("orderList",e);
            System.out.println(e);
        }
        return map;
    }

    /**
     * 删除订单
     * */
    @RequestMapping("deleteByID")
    public Map<String,Object> deleteByID(@RequestBody order order){
        Map<String,Object> map =new HashMap<>();
        try{
            System.out.println(order.getOrder_id());
            ordersservice.deleteByID(order.getOrder_id());
            map.put("state",true);
            map.put("msg","删除订单成功,请刷新!");
        }catch (Exception e){
            map.put("state",false);
            map.put("msg","删除订单失败，请重试!");
        }
        return map;
    }

    /**
     * 修改订单状态
     * */
    @RequestMapping("changeOrderFlag")
    public Map<String,Object> changeOrderFlag(@RequestBody Map<String,Object> datas){
        Map<String,Object> map =new HashMap<>();
        try{
            ordersservice.changeOrderFlag((String) datas.get("order_id"),(String) datas.get("order_flag"));
            map.put("state",true);
            map.put("msg","支付成功！请前往待出行订单查看!");
        }catch (Exception e){
            map.put("state",false);
            map.put("msg","支付失败!请重试");
            System.out.println(e);
        }
        return map;

    }

    /**
     * 根据订单编号查询订单
     * */
    @RequestMapping("searchByID")
    public Map<String,Object> searchByID(@RequestBody orders orders){
        Map<String,Object> map =new HashMap<>();
        try{
            orders ordersDB=ordersservice.searchByID(orders.getOrder_id());
            map.put("state",true);
            map.put("msg","订单查询成功！");
            map.put("orders",ordersDB);

        }catch (Exception e){
            map.put("state",false);
            map.put("msg","订单查询失败！请重试");
            map.put("orders",e);
        }
        return map;
    }

}
