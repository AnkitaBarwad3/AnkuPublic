package com.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.NewsDao;
import com.app.model.News;

@ComponentScan
@Service
@Transactional
public class NewsServiceImpl implements NewsService
{
	@Autowired
	private NewsDao newsDao;

	@Override
	public List<News> findAll()
	{
		List<News> newsList = new ArrayList<News>();
		for (News news : newsDao.findAll())
		{
			newsList.add(news);
		}
		return newsList;
	}

	@Override
	public void saveNews(News news)
	{
		newsDao.save(news);
	}

	@Override
	public News findOne(Integer id)
	{
		
		return newsDao.findOne(id);
	}

	@Override
	public void delete(Integer id)
	{
		newsDao.delete(id);
	}

	@Override
	public List<News> findByHeadline(String name)
	{
		return null;
	}

	@Override
	public List<News> findByDate(Date date)
	{
		return newsDao.findByDate(date);
	}

}
