package com.simplilearn.maricel.vdf.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage() {
        return "login-page";
    }

    @PostMapping("/home")
    public String showHomePage(){
        return "home";
    }

    @GetMapping("/getProducts")
    public String getProducts(){

        return "customer";
    }
}
