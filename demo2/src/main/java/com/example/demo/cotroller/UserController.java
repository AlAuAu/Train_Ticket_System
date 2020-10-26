package com.example.demo.cotroller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
@CrossOrigin
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 用来处理用户登录
     */
    @PostMapping("login")
    public  Map<String,Object> login(@RequestBody User user){

        Map<String,Object> map=new HashMap<>();
        try{
            User userDB=userService.login(user);
            map.put("state",true);
            map.put("msg","提示：登录成功");
            map.put("user",userDB);
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }


    /**
     * 用来处理用户注册方法
     */
    @PostMapping("register")
    public Map<String,Object> regist(@RequestBody User user){

        Map<String,Object> map=new HashMap<>();
        try {
            userService.register(user);
            map.put("state",true);
            map.put("msg","提示：注册成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示：注册失败");
        }
        return map;

    }

    /**
     * 修改个人信息
     * */
    @RequestMapping("edit")
    public Map<String,Object> edit(@RequestBody  Map<String,Object> datas){
        Map<String,Object> map=new HashMap<>();
        try {
            userService.edit((String) datas.get("user_tel"),(String) datas.get("user_pwd"));
            map.put("state",true);
            map.put("msg","提示：修改密码成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示：修改密码失败");
        }
        return map;
    }
}

