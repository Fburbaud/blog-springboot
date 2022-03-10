package com.printemps.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.printemps.blog.model.User;
import com.printemps.blog.services.UserServices;

@Controller
public class RegisterController {

	@Autowired
	private UserServices userServices;
	
	@GetMapping("/register")
	public String register(){
		return ("user/register");
	}

	@PostMapping("/register")
	public String register(@Validated User user, BindingResult bindingResult, Model model, HttpSession session) {
		model.addAttribute("user", new User());
		if(bindingResult.hasErrors()) {
        	return ("user/register");
        }
		userServices.createUser(user);
       
        session.setAttribute("username", user.getNom());
        model.addAttribute("username", user.getNom());
        return "redirect:/register?success"; 
        
	
	}

}
