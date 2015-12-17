package com.instapost.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instapost.domain.Category;
import com.instapost.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value={"/", "/list"}, method=RequestMethod.GET)
	public String listCategory(Model model){
		model.addAttribute("category", categoryService.listCategory());
		return "category/listCategory";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCategoryForm(@ModelAttribute("addCategoryForm") Category category, Model model) {		
		return "category/addCategory";

	}

//	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
//	public String saveCategory(@Valid @ModelAttribute("addCategoryForm") Category category,BindingResult result) {
//		if(result.hasErrors()){
//			return "category/addCategory";
//			
//		}
//		categoryService.addCategory(category);
//		return "redirect:/listCategory";
//	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Category saveCategory(@Valid @RequestBody Category category) {
		
		return categoryService.addCategory(category);
		 
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String updateCategory(@ModelAttribute("updateCategory") Category category, @PathVariable("id") long id, Model model) {
		
		category=categoryService.getCategoryById(id);
		model.addAttribute("updateCategory", category);

		return "category/updateCategoryForm";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
	public String updatedCategory(@ModelAttribute("updateCategory") Category category,@PathVariable("id") long id){
		categoryService.updateCategory(category);
		return "redirect:/category/list";
		
	}
	
//	@RequestMapping(value="/category_delete/{id}", method=RequestMethod.GET)
//	public String deleteCategory(Category category,@PathVariable("id") long id){
//		System.out.println(category.toString());
//		categoryService.deleteCategory(category);
//		
//		return "redirect:/listCategory";		
//	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public @ResponseBody boolean deleteCategory(Category category, @PathVariable("id") long id){
		category.setId(id);
		categoryService.deleteCategory(category);
		return true;
	}
}
