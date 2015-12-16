package com.instapost.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.instapost.domain.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {

}
