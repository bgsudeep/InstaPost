package com.instapost.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instapost.domain.Category;
import com.instapost.domain.News;
import com.instapost.service.CategoryService;
import com.instapost.service.NewsService;
import com.instapost.service.UserService;
import com.instapost.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	NewsService newsService;

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addNews(@ModelAttribute("newNews") News news, Model model) {
		List<Category> categories = categoryService.listCategory();
		model.addAttribute("categories", categories);
		return "news/addNews";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveNews(@Valid @ModelAttribute("newNews") News news, BindingResult result, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			List<Category> categories = categoryService.listCategory();
			model.addAttribute("categories", categories);
			return "news/addNews";
		}

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		com.instapost.domain.User userProfile = userService.findUserByEmail(user.getUsername());
		news.setUser(userProfile);
		
		newsService.addNews(news);
		return "redirect:/news/list";
	}

	@RequestMapping(value = {"/list", "/"}, method = RequestMethod.GET)
	public String listNews(Model model) {
		model.addAttribute("listNews", newsService.listPublishedNews());
		return "news/listNews";
	}
}
