package com.instapost.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.instapost.domain.Magazine;
import com.instapost.domain.News;
import com.instapost.service.MagazineService;
import com.instapost.service.NewsService;
import com.instapost.service.UserService;

@RequestMapping(value = { "/magazine" })
@Controller
public class MagazineController {
	@Autowired
	MagazineService magazineService;
	
	@Autowired
	NewsService newsService;
	
	@Autowired
	UserService userService;

	// add magazine
	@RequestMapping(value = { "/add"}, method = RequestMethod.GET)
	public String magazineFormDisplay(@ModelAttribute("magazine") Magazine newMazine) {

		return "magazine/magazineform";

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String magazineFormProcess(@Valid @ModelAttribute("magazine") Magazine magazine, BindingResult result) {
		if (result.hasErrors()) {
			return "magazine/magazineform";

		}
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		com.instapost.domain.User userProfile = userService.findUserByEmail(user.getUsername());
		
		magazine.setUser(userProfile);

		magazineService.saveMagazine(magazine);
		return "redirect:/magazine/list";

	}

	// edit magazine 
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editMagazineform(@ModelAttribute("magazine") Magazine magazine, Model model,
			@PathVariable("id") long id) {
		magazine = magazineService.findoneMagazine(id);
		model.addAttribute("magazine", magazine);

		return "magazine/magazineEditForm";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String magazineEditProcess(@Valid @ModelAttribute("magazine") Magazine magazine, BindingResult result) {
		if (result.hasErrors()) {
			return "magazine/magazineEditForm";
		}
		magazineService.saveMagazine(magazine);
		return "redirect:/magazine/list";

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteMagazine(Model model, @PathVariable("id") long magzineId) {
		magazineService.deleteMagazine(magzineId);

		return "redirect:/magazine/list";
	}

	// List magazine

	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String listMagazine(@ModelAttribute("magazine") Magazine magazine, Model model) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		com.instapost.domain.User userProfile = userService.findUserByEmail(user.getUsername());
		
		
		List<Magazine> magazineList = new ArrayList<Magazine>();
		List<Magazine> magazines = magazineService.listMagazine();
		for (Magazine _magazine : magazines) {
			if(_magazine.getUser().getId() == userProfile.getId()) {
				magazineList.add(_magazine);
			}
		}
		model.addAttribute("magazineList", magazineList);
		return "magazine/magazineDetails";
	}

	@RequestMapping(value = "/{id}/news", method = RequestMethod.GET)
	public String listNewsOfMagazine(Model model, @PathVariable("id") long magzineId) {

		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		com.instapost.domain.User userProfile = userService.findUserByEmail(user.getUsername());
		
		List<Magazine> magazineList = new ArrayList<Magazine>();
		List<Magazine> magazines = magazineService.listMagazine();
		for (Magazine _magazine : magazines) {
			if(_magazine.getUser().getId() == userProfile.getId()) {
				magazineList.add(_magazine);
			}
		}
		
		model.addAttribute("magazineList", magazineList);
		
		Magazine magazine = magazineService.findoneMagazine(magzineId);
		
		model.addAttribute("magazine", magazine);
		return "magazine/news";
	}
	
	@RequestMapping(value = "/news/add", method = RequestMethod.POST)
	public String addNews(@RequestParam("magazineId") long magazineId, @RequestParam("newsId") long newsId, Model model) {
		
		News news = newsService.getNewsById(newsId);
		Magazine magazine = magazineService.findoneMagazine(magazineId);
		news.setMagazine(magazine);
		
		newsService.addNews(news);
		
		return "redirect:/magazine/list";
	}
}
