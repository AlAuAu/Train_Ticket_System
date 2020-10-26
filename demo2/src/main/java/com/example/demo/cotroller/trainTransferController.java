package com.example.demo.cotroller;

import com.example.demo.entity.trainTransfer;
import com.example.demo.service.trainTransferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/trainTransfer")
public class trainTransferController {
    @Autowired
    private trainTransferService trainTransferservice;

    /**?
     * 用来处理查询转乘
     */
    @PostMapping("searchTransation")
    public Map<String,Object> searchTransation(@RequestBody trainTransfer traintransfer){
        Map<String,Object> map=new HashMap<>();
        try{
            System.out.println(traintransfer);
            List<trainTransfer> traintransferlist=trainTransferservice.searchTransation(traintransfer);
            map.put("state",true);
            map.put("msg","提示：查询成功");
            map.put("traintransferlist",traintransferlist);

        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;

    }
}
