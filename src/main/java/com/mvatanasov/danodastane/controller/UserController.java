package com.mvatanasov.danodastane.controller;

import com.mvatanasov.danodastane.dao.UserRepository;
import com.mvatanasov.danodastane.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController  {
@Autowired
    private UserRepository userRepository;

    @GetMapping(value = {"/","/home","/index","/welcome"})
    public String getIndex(Model model){
        model.addAttribute("user", new User());
        return "index";

    }

    @PostMapping(value="/postLogin")
    public String postLogin(@ModelAttribute User user,Model model){
        model.addAttribute("user",user);

        return "login";
    }

    @PostMapping(value="/postRegister")
    public String postRegister(@ModelAttribute User user,Model model) throws Exception {
        model.addAttribute("user",user);
        userRepository.insertUser(user);

        return "login";
    }

}
