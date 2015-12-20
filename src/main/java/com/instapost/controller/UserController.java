package com.instapost.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instapost.domain.Magazine;
import com.instapost.domain.News;
import com.instapost.domain.Role;
import com.instapost.domain.User;
import com.instapost.service.MagazineService;
import com.instapost.service.NewsService;
import com.instapost.service.RoleService;
import com.instapost.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final int ROLE_USER = 2;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	NewsService newsService;
	
	@Autowired
	MagazineService magazineService;
	
	/*
	 * GET request for the adding a new user
	 * @param user User Entity
	 * @param model holder for model attribute
	 * @return addUpdateUser.jsp view
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddUser(@ModelAttribute("user") User user, Model model) {
		List<Role> roles = new ArrayList<Role>();
		Role role = roleService.getRoleById(ROLE_USER);
		roles.add(role);
		
		model.addAttribute("roles", roles);
		return "user/addUpdateUser";
	}
	
	/*
	 * POST request for the saving a user
	 * @param user User Entity
	 * @param result checking for the errors in validation for user
	 * @param model holder for model attribute
	 * @return addUpdateUser.jsp view
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		
		//check for the creating a new user or updating a user
		if(user.getId() == null) {

			//new employee, add it
			if(result.hasErrors()) {
				List<Role> roles = new ArrayList<Role>();
				Role role = roleService.getRoleById(ROLE_USER);
				roles.add(role);
				
				model.addAttribute("roles", roles);
				return "user/addUpdateUser";
			}
			
			userService.save(user);
		}
		else {
			Role role = roleService.getRoleById(user.getRole().getId());
			user.setRole(role);
			userService.save(user);
		}
		
		return "redirect:/welcome";
	}
	
	/*
	 * GET request for the editing a new user
	 * @param user User Entity
	 * @param model holder for model attribute
	 * @return addUpdateUser.jsp view
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editUserWithId(@PathVariable("id") Long userId, Model model) {
		
		User user = userService.findById(userId);
		List<Role> roles = new ArrayList<Role>();
		roles.add(user.getRole());
		model.addAttribute("roles", roles);
		model.addAttribute("mode", "edit");
		model.addAttribute("user", user);
		
		return "user/addUpdateUser";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(Model model) {
		
		org.springframework.security.core.userdetails.User _user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findUserByEmail(_user.getUsername());
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(user.getRole());
		model.addAttribute("roles", roles);
		model.addAttribute("mode", "edit");
		model.addAttribute("user", user);
		
		return "user/addUpdateUser";
	}
	
	/*
	 * GET request for deleting a user
	 * @param user User Entity
	 * @param model holder for model attribute
	 * @return addUpdateUser.jsp view
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") long userId, Model model) {
		User user = userService.findById(userId);
		user.setRole(null);
		//find the news by this user
		List<News> newsList = newsService.listNews();
		
		for (News news : newsList) {
			if(news.getUser().getId() == userId) {
				news.setUser(null);
				newsService.addNews(news);
				newsService.deleteNews(news.getId());
			}
		}
		
		//find the magazines by this user
		List<Magazine> magazineList = magazineService.listMagazine();
		for (Magazine magazine : magazineList) {
			if(magazine.getUser().getId() == userId) {
				magazine.setUser(null);
				magazineService.saveMagazine(magazine);
				magazineService.deleteMagazine(magazine.getId());
			}
		}
		
		userService.delete(user);
		
		return "redirect:/user/list";
	}
	
	/*
	 * GET request for listing of the users
	 * @param user User Entity
	 * @param model holder for model attribute
	 * @return listUsers.jsp view
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUser(Model model) {
		List<User> users = userService.findAll();

		model.addAttribute("listUser", users);

		return "user/listUsers";
	}
	
	
	
}
