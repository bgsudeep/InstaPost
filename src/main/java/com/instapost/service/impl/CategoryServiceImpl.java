package com.instapost.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.instapost.domain.Category;
import com.instapost.repository.CategoryRepository;
import com.instapost.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		
		return categoryRepository.save(category) ;
	}
	
	@Override
	public List<Category> listCategory() {
		
		return (List<Category>) categoryRepository.findAll();
	}
	
	
	@Override
	public Category getCategoryById(Long id) {
		Category category = categoryRepository.findOne(id);	
		return category;
	}
	
	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}
	@Override
	public Category deleteCategory(Category category) {
		categoryRepository.delete(category);
		return null;
	}
	
	
	
	

}
