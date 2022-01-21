package com.example.shiro2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/login.html")
    public String login(){
        System.out.println("登录页");
        return "login";
    }

    @RequestMapping("/")
    public String login1(){
        System.out.println("登录页");
        return "login";
    }

    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }
}
