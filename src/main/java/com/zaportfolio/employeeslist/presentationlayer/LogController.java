package com.zaportfolio.employeeslist.presentationlayer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogController {
    @GetMapping("/loginPage")
    public String logHandler(){
        return "form/login";
    }
    @GetMapping("/access-denied")
    public String accessDeniedHandler(){
        return  "form/accessDenied";
    }
}
