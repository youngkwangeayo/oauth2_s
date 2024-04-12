package com.mydata.authlogin.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.mydata.authlogin.security.AuthUser;


@Controller()
@RequestMapping("/member")
public class MemberController {
    
    @GetMapping("/hi")
    public @ResponseBody String testget(@AuthenticationPrincipal AuthUser user) {
        String hello = "유저컨트롤";
        
        return user.toString();
    }

    // @GetMapping("/login")
    // public String gettest() {
    //     return "login";
    // }

    // @PostMapping("/login")
    // public String loginRequest() {
    //     return "login";
    // }
    
    

}
