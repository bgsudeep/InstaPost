package com.instapost.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.instapost.domain.Category;

public interface CategoryService {
	@PreAuthorize ("hasRole('ROLE_ADMIN')")
	public Category addCategory(Category category);
//	@PreAuthorize ("hasRole('ROLE_ADMIN')")
	public List<Category> listCategory();
//	@PreAuthorize ("hasRole('ROLE_ADMIN')")
	public Category getCategoryById(Long id);
	@PreAuthorize ("hasRole('ROLE_ADMIN')")
	public Category updateCategory(Category category);
	@PreAuthorize ("hasRole('ROLE_ADMIN')")
	public Category deleteCategory(Category category);
}
