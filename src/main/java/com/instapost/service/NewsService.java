package com.instapost.service;

import java.util.List;

import com.instapost.domain.News;

public interface NewsService {
	public News addNews(News news);
	public List<News> listNews();
	public List<News> listPublishedNews();
	public List<News> listUnPublishedNews();
	public News getNewsById(Long id);
	public News updateNews(News news);
	public News deleteNews(News news);
		
}
