package com.instapost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.instapost.domain.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {
	@Query("select n FROM NEWS n WHERE n.isPublish=1")
	public List<News> findPublishedNews();

	@Query("select n FROM NEWS n WHERE n.isPublish=0")
	List<News> findUnPublishedNews();

}
