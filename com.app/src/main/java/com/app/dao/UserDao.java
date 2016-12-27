package com.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.model.User;

public interface UserDao extends CrudRepository<User, Integer>
{
	public User findByEmailIdAndPassword(String emailId, String password); 
}
