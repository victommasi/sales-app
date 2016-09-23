package com.victommasi.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@RequestMapping("/login")
	public String login(@AuthenticationPrincipal User user){
		
		if(user != null){
			return "redirect:/home";
		}
		
		return "login";
	}
}
