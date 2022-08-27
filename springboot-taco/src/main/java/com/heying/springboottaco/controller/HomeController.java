package com.heying.springboottaco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")//一级路径
    @ResponseBody
    public String home() {

        System.out.println("12312312");
        System.out.println("oneMoreTimes");
        System.out.println("oneMore");
        return "Hello SpringBoot @_@atGuiguXF";
    }

}
