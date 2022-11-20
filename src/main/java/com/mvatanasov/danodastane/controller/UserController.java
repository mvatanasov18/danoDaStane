package com.mvatanasov.danodastane.controller;

import com.mvatanasov.danodastane.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @GetMapping(value = {"/","/home","/index","/welcome"})
    public String displayIndex(Model model){
        model.addAttribute("user", new User());
        return "index";

    }

    @PostMapping(value="/postLogin")
    public String getLogin(@ModelAttribute User user,Model model){
        model.addAttribute("user",user);
        return "login";
    }
}
