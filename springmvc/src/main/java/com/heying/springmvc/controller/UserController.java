package com.heying.springmvc.controller;

import com.heying.springmvc.Database;
import com.heying.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")//一级路径
public class UserController {

    @RequestMapping("/toadd")
    public String toAdd() {
        return "adduser";
    }

    @RequestMapping("/addone")
    public String addOne(User user, Model model) {
        Database.userMap.put(user.getId(), user);
        System.out.println(Database.userMap);
        model.addAttribute("info", "添加成功喔");
        return "success";
    }
}
