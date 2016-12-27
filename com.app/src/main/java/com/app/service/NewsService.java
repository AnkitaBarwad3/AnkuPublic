package com.app.service;

import java.util.Date;
import java.util.List;

import com.app.model.News;

public interface NewsService
{
		public List<News> findAll();
	
		public void saveNews(News news);

	    public News findOne(Integer id);

	    public void delete(Integer id);

	    public List<News> findByHeadline(String name);

	    public List<News> findByDate(Date date);
}
