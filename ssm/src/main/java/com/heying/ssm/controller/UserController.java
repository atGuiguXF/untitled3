package com.heying.ssm.controller;

import com.heying.ssm.entity.UserInfo;
import com.heying.ssm.service.UserServiceIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceIn userService;

    @RequestMapping("/queryone")
    @ResponseBody
    public UserInfo queryOne(String username) {
        return userService.queryOne(username);
    }

    @RequestMapping("/addone")
    @ResponseBody
    public Integer addOne(String username, String password) {
        final UserInfo userinfo = new UserInfo(username, password);
        return userService.addOne(userinfo);
    }


    @RequestMapping("/deleteone")
    @ResponseBody
    public Boolean deleteOne(String username){
        return userService.deleteOne(username);
    }

    @RequestMapping("/update")
    public Boolean updateOne(String username,String password){
        final UserInfo userInfo = new UserInfo(username, password);
        return userService.updateOne(userInfo);
    }
}
