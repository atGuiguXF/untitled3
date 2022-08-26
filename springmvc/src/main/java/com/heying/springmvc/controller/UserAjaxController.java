package com.heying.springmvc.controller;

import com.heying.springmvc.Database;
import com.heying.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

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

    @RequestMapping("/querysome")
    @ResponseBody
    public List<User> querySome(String username, String sex){
        return Database.userMap.values().stream().filter(user -> {
            boolean flag = true;
            if(username.length() > 0) {
                flag = user.getUsername().matches(".*" + username + ".*");
            }
            if(sex.length() > 0) {
                flag = flag && user.getSex().equals(sex);
            }
            return flag;
        }).collect(Collectors.toList());
    }
}
