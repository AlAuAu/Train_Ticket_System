package com.example.demo.cotroller;

import com.example.demo.entity.orders;
import com.example.demo.entity.trainRemain;
import com.example.demo.service.trainRemainService;
import lombok.extern.slf4j.Slf4j;
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
@RestController
@RequestMapping("/trainRemain")
@CrossOrigin
@Slf4j
public class trainRemainController {
    @Autowired
    private trainRemainService trainremainservice;

    /*
    *查询余票数量
     */

    @RequestMapping("count_Ticket")
    public Map<String,Object> count_Ticket(@RequestBody orders orders){
        System.out.println(orders);
        Map<String,Object> map=new HashMap<>();
        try{
            List<trainRemain> trainRemains=trainremainservice.count_Ticket(orders.getTrain_id(),orders.getTrain_date(),orders.getStart_stop_id(),orders.getEnd_stop_id());
            map.put("state",true);
            map.put("msg","查询成功");
            map.put("trainRemians",trainRemains);
        }catch (Exception e){
            map.put("state",false);
            map.put("msg","查询失败");
            map.put("trainRemians",e.getMessage());
        }
        return map;

    }
}
