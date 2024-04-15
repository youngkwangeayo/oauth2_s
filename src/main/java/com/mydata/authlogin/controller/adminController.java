package com.mydata.authlogin.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.mydata.authlogin.security.AuthUser;


@Controller
@RequestMapping("admin")
public class adminController {
    
    @GetMapping("hi")
    public String adminHi(@AuthenticationPrincipal AuthUser user) {


        return user.toString();
    }
    
}
