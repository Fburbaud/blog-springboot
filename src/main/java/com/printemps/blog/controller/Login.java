package com.printemps.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.printemps.blog.model.User;

@Controller
public class Login {
	
	 @GetMapping("/login")
    public String login(Model model){
		 model.addAttribute("user", new User());
		 return "user/login";
    }
}
