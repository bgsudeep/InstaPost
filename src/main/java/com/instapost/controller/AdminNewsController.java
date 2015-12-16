package com.instapost.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instapost.domain.News;
import com.instapost.service.CategoryService;
import com.instapost.service.NewsService;
import com.instapost.service.UserService;

@Controller
@RequestMapping("/admin/news")
public class AdminNewsController {

	@Autowired
	NewsService newsService;

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/publish/{id}", method = RequestMethod.GET)
	public String publishNews(@PathVariable("id") long id, Model model, HttpServletRequest request) {
		News news = newsService.getNewsById(id);
		news.setPublish(true);
		newsService.addNews(news);
		return "redirect:"+request.getHeader("Referer");
	}

	@RequestMapping(value = "/unpublish/{id}", method = RequestMethod.GET)
	public String unPublishNews(@PathVariable("id") long id, Model model, HttpServletRequest request) {
		News news = newsService.getNewsById(id);
		news.setPublish(false);
		newsService.addNews(news);
		return "redirect:"+request.getHeader("Referer");
	}	
	
	@RequestMapping(value = {"/published"}, method = RequestMethod.GET)
	public String listPublishedNews(Model model) {
		model.addAttribute("listNews", newsService.listPublishedNews());
		return "news/listNews";
	}
	
	@RequestMapping(value = {"/unpublished"}, method = RequestMethod.GET)
	public String listUnPublishedNews(Model model) {
		model.addAttribute("listNews", newsService.listUnPublishedNews());
		return "news/listNews";
	}	
	
	@RequestMapping(value = {"/list", "/"}, method = RequestMethod.GET)
	public String listNews(Model model) {
		model.addAttribute("listNews", newsService.listNews());
		return "news/listNews";
	}
}
