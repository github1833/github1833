package com.example.shiro2.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    public boolean checkLogin(String n, String p) {
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(n, p);

        try{
            subject.login(token);
            return true;
        } catch (Exception exception){
            return false;
        }

    }
}
