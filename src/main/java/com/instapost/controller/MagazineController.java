package com.instapost.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instapost.domain.Magazine;
import com.instapost.service.MagazineService;

@RequestMapping(value = { "/magazine" })
@Controller
public class MagazineController {
	@Autowired
	MagazineService magazineService;

	// add magazine
	@RequestMapping(value = { "/addmagazine", "/" }, method = RequestMethod.GET)
	public String magazineFormDisplay(@ModelAttribute("magazine") Magazine newMazine) {

		return "magazine/magazineform";

	}

	@RequestMapping(value = "/addmagazine", method = RequestMethod.POST)
	public String magazineFormProcess(@Valid @ModelAttribute("magazine") Magazine magazine, BindingResult result) {
		if (result.hasErrors()) {
			return "magazine/magazineform";

		}

		magazineService.saveMagazine(magazine);
		return "redirect:/magazine/saveMagazine";

	}

	@RequestMapping(value = "/saveMagazine", method = RequestMethod.GET)
	public String magazineSave(@ModelAttribute("magazine") Magazine newMazine) {

		return "redirect:/magazine/list";

	}

	// edit magazine 
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editMagazineform(@ModelAttribute("magazine") Magazine magazine, Model model,
			@PathVariable("id") Integer id) {
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
		return "redirect:/magazine/editsaveMagazine";

	}

	@RequestMapping(value = "/editsaveMagazine", method = RequestMethod.GET)
	public String editMagazineSave(@ModelAttribute("magazine") Magazine newMazine) {

		return "redirect:/magazine/list";

	}

	// delete magazine 

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteMagazine(Model model, @PathVariable("id") Integer magzineId) {
		magazineService.deleteMagazine(magzineId);

		return "redirect:/magazine/list";
	}

	// List magazine

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listMagazine(@ModelAttribute("magazine") Magazine magazine, Model model) {

		List<Magazine> magazineList = new ArrayList<Magazine>();
		magazineList = magazineService.listMagazine();
		model.addAttribute("magazineList", magazineList);
		return "magazine/magazineDetails";
	}

	@RequestMapping(value = "/newsList/{id}", method = RequestMethod.GET)
	public String listNewsOfMagazine(Model model, @PathVariable("id") Integer magzineId) {

		Magazine magazine = magazineService.findoneMagazine(magzineId);
		model.addAttribute("magazine", magazine);
		return "magazine/news";
	}

}
