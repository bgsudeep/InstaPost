package com.instapost.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.instapost.domain.Magazine;

@Repository
public interface MagazineRepository extends CrudRepository<Magazine, Long>{
	
}
