package com.heying.springmvc.controller;

import com.heying.springmvc.Database;
import com.heying.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")//一级路径 根路径
public class UserController {

    @RequestMapping("/toadd")
    public String toAdd(){
        return "adduser";
    }

    @RequestMapping("/addone")
    public String addOne(User user, Model model){
        Database.userMap.put(user.getId(), user);
        System.out.println(Database.userMap);
        model.addAttribute("info", "添加成功");
        return"success";
    }
    @RequestMapping("/tomod")
    public String toMod(Integer id,Model model){
        final User user = Database.userMap.get(id);
        model.addAttribute("user", user);
        return "moduser";
    }

    @RequestMapping("/querysome")
    public String querySome(String username,String sex,Model model){
        final List<User> users = Database.userMap.values().stream().filter(user -> {
            boolean flag = true;
            if(username.length() > 0) {
                flag = user.getUsername().matches(".*" + username + ".*");
            }
            if(sex.length() > 0) {
                flag = flag && user.getSex().equals(sex);
            }
            return flag;
        }).collect(Collectors.toList());
        model.addAttribute("users", users);
        return "userlist";
    }

    @RequestMapping("/queryone")
    public String queryOne(Integer id,Model model){
        final User user = Database.userMap.get(id);
        model.addAttribute("user", user);
        return "moduser";
    }
}
