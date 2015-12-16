package com.instapost.service;

import java.util.List;

import com.instapost.domain.Category;

public interface CategoryService {
	
	
	public Category addCategory(Category category);
	public List<Category> listCategory();
	public Category getCategoryById(Long id);
	public Category updateCategory(Category category);
	public Category deleteCategory(Category category);
	
}
