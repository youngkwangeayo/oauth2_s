package com.mydata.authlogin.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mydata.authlogin.security.AuthUser;





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
  

    @GetMapping("member/exampleUser")
    public @ResponseBody String exampleUser(@AuthenticationPrincipal AuthUser user) {
        user.getMember().toString();
        return user.getUsername();
    }
    

}
