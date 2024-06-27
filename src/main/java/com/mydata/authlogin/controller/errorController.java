// package com.mydata.authlogin.controller;

// import org.springframework.boot.web.servlet.error.ErrorController;
// import org.springframework.http.HttpStatus;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;

// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;


// @Controller

// public class errorController implements ErrorController {

//     @RequestMapping(value = "/error")
//     public @ResponseBody String requestMethodName(HttpServletRequest req, HttpServletResponse res) {
//         String errorType = HttpStatus.INTERNAL_SERVER_ERROR.toString();
//         System.out.println("=er="+errorType);
//         if(errorType.contains("403")){
//             return "권한이 없습니당.";
//         }
//         // System.out.println("o"+o.toString());
//         return errorType;
//     }
    
    
// }
