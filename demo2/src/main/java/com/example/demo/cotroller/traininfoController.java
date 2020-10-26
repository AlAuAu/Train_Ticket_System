package com.example.demo.cotroller;

import com.example.demo.entity.traininfo;
import com.example.demo.service.traininfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
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
@RequestMapping("/traininfo")
@RestController
@CrossOrigin
@Slf4j
public class traininfoController {
    @Autowired
    private traininfoService train_infoServiece;
    /**
     * 查询不需要转乘的列车信息
     */

    @RequestMapping("search")
    public Map<String,Object> search(@RequestBody traininfo train_info){
        Map<String,Object> map=new HashMap<>();
        try{
           List<traininfo> train_infoDB=train_infoServiece.search(train_info);
            map.put("state",true);
            map.put("msg","提示：查询成功");
            map.put("traininfoList",train_infoDB);
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return  map;

    }

    @RequestMapping("changeTrainInfo")
    public Map<String ,Object> changeTrainInfo(@RequestBody Map<String,Object> datas){
        Map<String,Object> map =new HashMap<>();
        try{
            List<traininfo> traininfoDB=train_infoServiece.changeTrainInfo((String) datas.get("start_city_name"),(String) datas.get("end_city_name"),(String) datas.get("start_date"));
            map.put("state",true);
            map.put("msg","查询列车信息成功！");
            map.put("traininfoList",traininfoDB);
        }catch (Exception e){
            map.put("state",false);
            map.put("msg","查询列车信息失败请重试！");
            System.out.println(e);
        }
        return map;

    }

}
