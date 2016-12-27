package com.app.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.News;
import com.app.model.User;
import com.app.service.NewsService;

@ComponentScan
@RestController
@RequestMapping("/news")
public class NewsController
{
	@Autowired
	 NewsService newsService;

	@RequestMapping("/users")
	public List<News> getAllNews()
	{
 		return  newsService.findAll();
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public News getNewsById(@PathVariable(value="id") int id)
	{
 		return  newsService.findOne(id);
	}
	
	@RequestMapping(value="/save")
	public  String addNews(@RequestParam String h, @RequestParam String d)
	{
		User u = new User();
		u.setIduser(1);
		News news = new News(u, new Date(), h, d);
		newsService.saveNews(news);
		return "News Successfully Added";
	}
	
}