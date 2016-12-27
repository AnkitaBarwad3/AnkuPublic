package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.model.User;

@ComponentScan
@Service
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired
	UserDao userDao;
	
	@Override
	public void saveUser(User user)
	{
		userDao.save(user);
	}

	@Override
	public User findOne(Integer id)
	{
		return userDao.findOne(id);
	}

	@Override
	public void delete(Integer id)
	{
		userDao.delete(id);
	}

	@Override
	public User findByEmailIdAndPassword(String email_Id, String password)
	{
		return userDao.findByEmailIdAndPassword(email_Id, password);
	}
}
