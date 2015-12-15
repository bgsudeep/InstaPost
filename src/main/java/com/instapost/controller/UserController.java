package com.instapost.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instapost.domain.Role;
import com.instapost.domain.User;
import com.instapost.service.RoleService;
import com.instapost.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String getAddUser(@ModelAttribute("newUser") User user, Model model) {
		return "user/addUser";
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "user/addUser";
		}
		
		userService.save(user);
		
		return "redirect:/welcome";
	}
	
}
