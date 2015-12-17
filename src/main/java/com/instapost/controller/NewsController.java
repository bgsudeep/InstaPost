package com.instapost.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instapost.domain.Category;
import com.instapost.domain.Magazine;
import com.instapost.domain.News;
import com.instapost.exception.CategoryNotFoundException;
import com.instapost.service.CategoryService;
import com.instapost.service.MagazineService;
import com.instapost.service.NewsService;
import com.instapost.service.UserService;

@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	NewsService newsService;

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MagazineService magazineService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addNews(@ModelAttribute("newNews") News news, Model model) {
		List<Category> categories = categoryService.listCategory();
		if(categories.isEmpty()){
			throw new CategoryNotFoundException();
		}
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
		Category category = categoryService.getCategoryById(news.getCategory().getId());
		news.setCategory(category);
		newsService.addNews(news);

		newsService.addNews(news);
		return "redirect:/news/list";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editNews(@ModelAttribute("newNews") News news, @PathVariable("id") long id, Model model) {
		List<Category> categories = categoryService.listCategory();
		if(categories.isEmpty()){
			throw new CategoryNotFoundException();
		}
		news = newsService.getNewsById(id);
		model.addAttribute("newNews", news);
		
		model.addAttribute("categories", categories);
		return "news/editNews";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editNews(@Valid @ModelAttribute("newNews") News news, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Category> categories = categoryService.listCategory();
			model.addAttribute("categories", categories);
			return "news/addNews";
		}
		Category category = categoryService.getCategoryById(news.getCategory().getId());
		news.setCategory(category);
		newsService.addNews(news);
		return "redirect:/news/list";
	}

	@RequestMapping(value = {"/list", "/"}, method = RequestMethod.GET)
	public String listNews(@ModelAttribute("newNews") News news, Model model) {
		List<News> newsList = newsService.listPublishedNews();

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		com.instapost.domain.User userProfile = userService.findUserByEmail(user.getUsername());

		List<Magazine> magazineList = new ArrayList<Magazine>();
		List<Magazine> magazines = magazineService.listMagazine();
		for (Magazine _magazine : magazines) {
			if(_magazine.getUser().getId() == userProfile.getId()) {
				magazineList.add(_magazine);
			}
		}
		
		model.addAttribute("listNews", newsList);
		model.addAttribute("listMagazines", magazineList);
		
		return "news/listNews";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteNews(Model model, @PathVariable("id") Long id) {
		newsService.deleteNews(id);
		return "redirect:/news/list";
	}
	
}
