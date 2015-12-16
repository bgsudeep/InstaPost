package com.instapost.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.instapost.domain.Category;
import com.instapost.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/listCategory", method=RequestMethod.GET)
	public String listCategory(Model model){
		model.addAttribute("category", categoryService.listCategory());
		return "category/listCategory";
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public String addCategoryForm(@ModelAttribute("addCategoryForm") Category category, Model model) {		
		return "category/addCategory";

	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String saveCategory(@Valid @ModelAttribute("addCategoryForm") Category category,BindingResult result) {
		if(result.hasErrors()){
			return "category/addCategory";
			
		}
		categoryService.addCategory(category);
		return "redirect:/listCategory";
	}

	@RequestMapping(value = "/category_edit/{id}", method = RequestMethod.GET)
	public String updateCategory(@ModelAttribute("updateCategory") Category category, @PathVariable("id") long id, Model model) {
		
		category=categoryService.getCategoryById(id);
		model.addAttribute("updateCategory", category);

		return "category/updateCategoryForm";

	}
	
	@RequestMapping(value="/category_edit/{id}", method = RequestMethod.POST)
	public String updatedCategory(@ModelAttribute("updateCategory") Category category,@PathVariable("id") long id){
		categoryService.updateCategory(category);
		return "redirect:/listCategory";
		
	}
	
	@RequestMapping(value="/category_delete/{id}", method=RequestMethod.GET)
	public String deleteCategory(@ModelAttribute("addCategoryForm") Category category,@PathVariable("id") long id){
		categoryService.deleteCategory(category);
		return "redirect:/listCategory";		
	}
}