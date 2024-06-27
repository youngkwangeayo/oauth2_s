package com.mydata.authlogin.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    
    @GetMapping("/login")
    public String loginform() {
        System.out.println("로그인컨트롤");
        return "/login";
    }

}
