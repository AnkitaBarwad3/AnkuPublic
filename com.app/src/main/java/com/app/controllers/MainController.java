package com.app.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.exception.BaseException;
import com.app.model.News;
import com.app.model.User;
import com.app.service.NewsService;
import com.app.service.UserService;

@ComponentScan
@Controller
public class MainController
{
	@Autowired
	 NewsService newsService;
	@Autowired
	UserService userService;
	@Autowired
	HttpSession session;

	@RequestMapping("/")
	public String showhomePage(HttpServletRequest req)
	{
		req.setAttribute("news_list", newsService.findAll());
		return "index";	
	}
	
	@RequestMapping("/ex")
	public String showExceptionPage(HttpServletRequest req)
	{
			req.setAttribute("news_list", newsService.findAll());
			throw new BaseException("asdkasdkakdskd");
	}
	
	
	@RequestMapping("/login")
	public String showloginPage()
	{
		return "login";	
	}
	

	@RequestMapping(value="/logged",method=RequestMethod.GET)
	public String showloginPage(HttpServletRequest req,ModelMap map)
	{
		HttpSession s = req.getSession(false);
		if(s != null)
		{
			req.setAttribute("news_list", newsService.findAll());
			return "user";
		}
		return "login";
	}
	
	@RequestMapping(value="/logged",method=RequestMethod.POST)
	public String processloginPage(@ModelAttribute User user,BindingResult rs ,HttpServletRequest req,ModelMap map)
	{
		HttpSession s = req.getSession(false);
		if(s != null)
		{
			User loginUser = userService.findByEmailIdAndPassword(user.getEmailId(), user.getPassword());
			if( loginUser != null)
			{
				req.setAttribute("news_list", newsService.findAll());
				session.setAttribute("loggedUser", loginUser);
				return "user";
			}
			map.addAttribute("status", "Invalid Username Or Password");
		}
		return "login";
	}
	
	@RequestMapping("/logout")
	public String processLogoutPage(ModelMap map, HttpServletRequest req)
	{
		HttpSession s = req.getSession(false);
		if(s != null)
		{
			session.invalidate();
			map.addAttribute("status", "Successfully Logged Out ... !");
		}
		return "login";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String processSavePage(@ModelAttribute News news,BindingResult rs ,HttpServletRequest req)
	{
		HttpSession s = req.getSession(false);
		if(s != null)
		{
			news.setUser((User)session.getAttribute("loggedUser"));
			news.setDate(new Date());
			newsService.saveNews(news);
			req.setAttribute("news_list", newsService.findAll());
			return "user";
		}
		return "login";
	}
	

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String showAddPage(HttpServletRequest req)
	{
		HttpSession s = req.getSession(false);
		if(s != null)
		{
			return "add";	
		}
		return "login";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String processSearchPage(@RequestParam("s") String sdate ,HttpServletRequest req, ModelMap map)
	{
		HttpSession s = req.getSession(false);
		if(s != null)
		{
			if(!sdate.equals("") && sdate != null)
			{
				 System.out.println("#####"+sdate);
				 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				 Date date  = null;
					 try
					 {
						 date = df.parse(sdate);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
				if(date != null)
				{
					map.addAttribute("Result", "Search Result By "+df.format(date));
					req.setAttribute("news_list", newsService.findByDate(date));
					return "index";
				}
			}
		}
		req.setAttribute("news_list", newsService.findAll());
		return "index";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String processUpdatePage(@RequestParam("id") Integer id ,HttpServletRequest req, ModelMap map)
	{
		HttpSession s = req.getSession(false);
		if(s != null)
		{
			if(id != null)
			{
				map.addAttribute("news", newsService.findOne(id));
			}
			req.setAttribute("news_list", newsService.findAll());
			return "add";	
		}
		return "login";
	}
	
	@RequestMapping(value="/delete")
	public String processDeletePage(@RequestParam("id") Integer id ,HttpServletRequest req)
	{
		HttpSession s = req.getSession(false);
		if(s != null)
		{
			newsService.delete(id);
			req.setAttribute("news_list", newsService.findAll());
			return "user";	
		}
		return "login";
	}
}
