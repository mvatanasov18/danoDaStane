package com.mvatanasov.danodastane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @RequestMapping(value = {"/","/home","/index","/welcome"})
    public String displayIndex(){
        return "index";

    }

    @RequestMapping(value="/postLogin", method = RequestMethod.POST)
    public String getLogin(HttpServletRequest request){
        return "Username Password: ";
    }
}
