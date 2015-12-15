package com.instapost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

  
@Controller
public class HomeController {

	@RequestMapping({"/", "/welcome"})
	public String welcome(Model model) {
		
		
		model.addAttribute("greeting", "Welcome to the Lone Ranger Company, Kimosabe!!");
		model.addAttribute("tagline", "The one and only place to work, so you can live and play!!");

/*
 		Customer c = new Customer();

		c.setLastName("Dreamer");
		c.setFirstName("Freddy");
 		c.setAge(15);
*/		
 		
//		customerService.save(c);
		
		return "welcome";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcome";
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String addUser(){
		return "user/addUser";
	}
	
	
}
