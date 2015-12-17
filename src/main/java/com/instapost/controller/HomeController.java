package com.instapost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instapost.service.UserService;

  
@Controller
public class HomeController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	public String welcome(Model model) {
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		com.instapost.domain.User userProfile = userService.findUserByEmail(user.getUsername());
		
		model.addAttribute("user", userProfile);
		return "welcome";
	}
	
	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
	public String aboutUs(Model model) {
		
		return "aboutUs";
	}
	
	
	
}
