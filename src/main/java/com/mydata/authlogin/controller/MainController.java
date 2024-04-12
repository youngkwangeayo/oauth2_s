package com.mydata.authlogin.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class MainController {
    
    @GetMapping("/")
    public String mainHome(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(name);
        if(name != "anonymousUser"){
            model.addAttribute("name", name);
        }

        
        return "index";
    }
    // @GetMapping("/login")
    // public String loginform() {
    //     System.out.println("로그인컨트롤");
    //     String hello = "헬로월드";
    //     return "/login";
    // }

    // @GetMapping("/login")
    // public @ResponseBody String testget() {
    //     String hello = "헬로월드";
    //     return hello;
    // }
    

}
