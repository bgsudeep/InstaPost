package com.instapost.controller;

import java.util.ArrayList;
import java.util.List;

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
public class ProfileController {
	
	private static final int ROLE_USER = 2;

	@Autowired
	RoleService roleService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getAddUser(@ModelAttribute("user") User user, Model model) {
		List<Role> roles = new ArrayList<Role>();
		Role role = roleService.getRoleById(ROLE_USER);
		roles.add(role);
		
		model.addAttribute("roles", roles);
		return "user/registerUser";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		
		if(user.getId() == null) {
			
			
			if(result.hasErrors()) {
				List<Role> roles = new ArrayList<Role>();
				Role role = roleService.getRoleById(ROLE_USER);
				roles.add(role);
				
				model.addAttribute("roles", roles);
				return "user/registerUser";
			}
			
			userService.save(user);
		}
		else {
			Role role = roleService.getRoleById(user.getRole().getId());
			user.setRole(role);
			userService.save(user);
		}
		return "redirect:/login";
	}
}
