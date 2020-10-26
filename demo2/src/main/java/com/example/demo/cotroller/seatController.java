package com.example.demo.cotroller;

import com.example.demo.entity.orders;
import com.example.demo.entity.seat;
import com.example.demo.service.seatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seat")
@CrossOrigin
@RestController
@Slf4j
public class seatController {
    @Autowired
    private seatService seatservice;

    /*
    * 查询座位位置
    * */
    @RequestMapping("searchSeat")
    public Map<String,Object> searchSeat(@RequestBody orders orders){
        Map<String,Object> map= new HashMap<>();
        try{
            List<seat> seatDB=seatservice.searchSeat(orders);
            map.put("state",true);
            map.put("msg","查询座位成功");
            map.put("seatList",seatDB);
        }catch (Exception e){
            map.put("state",false);
            map.put("msg","查询座位失败");
            map.put("seatList",e);
        }
        return  map;

    }

    /*
    * 查询座位的id
    * */
    @RequestMapping("searchID")
    public Map<String,Object> searchID(@RequestBody seat seat){
        Map<String,Object> map= new HashMap<>();
        try{
            String seatIDDB=seatservice.searchID(seat);
            map.put("state",true);
            map.put("msg","查询座位成功");
            map.put("seatID",seatIDDB);
        }catch (Exception e){
            map.put("state",false);
            map.put("msg","查询座位失败");
            map.put("seatList",e);
        }
        return  map;

    }


}
