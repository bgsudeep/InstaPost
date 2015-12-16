package com.instapost.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.instapost.domain.News;
import com.instapost.repository.NewsRepository;
import com.instapost.service.NewsService;

@Service
@Transactional
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	NewsRepository newsRepository;
	
	@Override	
	public News addNews(News news) {
		return newsRepository.save(news);
	}

	@Override
	public java.util.List<News> listNews() {
		return (List<News>) newsRepository.findAll();		
	}

	@Override
	public News getNewsById(Long id) {
		return (News) newsRepository.findOne(id);
	}

	@Override
	public News updateNews(News news) {
		return newsRepository.save(news);
	}

	@Override
	public News deleteNews(News news) {
		newsRepository.delete(news);
		return null;
	}

	@Override
	public List<News> listPublishedNews() {
		return (List<News>) newsRepository.findPublishedNews();
	}

	@Override
	public List<News> listUnPublishedNews() {
		return (List<News>) newsRepository.findUnPublishedNews();
	}
}
