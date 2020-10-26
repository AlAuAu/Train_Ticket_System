package com.example.demo.cotroller;


import com.example.demo.entity.passenger;
import com.example.demo.service.passengerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/passenger")
@Slf4j
@CrossOrigin
@RestController
public class passengerController {
    @Autowired
    private passengerService passengerservice;

    /*
     * 插入乘客
     */
    @RequestMapping("addPassenger")
    public Map<String,Object> addPassengert(@RequestBody passenger passenger){
        Map<String,Object> map=new HashMap<>();
        try{
            passengerservice.savePassenger(passenger);
            map.put("state",true);
            map.put("msg","添加乘客成功!");
        }catch (Exception e){
            map.put("state",false);
            map.put("msg",e);
        }
        return map;
    }
}
