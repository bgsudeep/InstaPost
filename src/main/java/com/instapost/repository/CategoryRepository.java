package com.instapost.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.instapost.domain.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
	
}
