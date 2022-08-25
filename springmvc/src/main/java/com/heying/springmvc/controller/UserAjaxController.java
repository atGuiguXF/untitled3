package com.heying.springmvc.controller;

import com.heying.springmvc.Database;
import com.heying.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
        ("/user/ajax")
@CrossOrigin("*")
public class UserAjaxController {

    @RequestMapping("/addone")
    @ResponseBody
    public String addOne(User user){
        Database.userMap.put(user.getId(), user);
        System.out.println(Database.userMap);
        return "success";
    }

    @RequestMapping("/tomod")
    @ResponseBody
    public User toMod(Integer id){
        return  Database.userMap.get(id);
    }
}
