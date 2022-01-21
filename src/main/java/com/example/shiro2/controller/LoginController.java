package com.example.shiro2.controller;


import com.example.shiro2.service.UserServiceImpl;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public String login(@RequestParam(name = "username") String username, @RequestParam(name = "passwd") String passwd){
        System.out.println(username);
        System.out.println(passwd);
        if (userService.checkLogin(username,passwd)){
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        return "index";
    }

}
