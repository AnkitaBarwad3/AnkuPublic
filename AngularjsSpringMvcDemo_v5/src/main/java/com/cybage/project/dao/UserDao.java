package com.cybage.project.dao;

import java.util.List;

import com.cybage.project.model.User;

public interface UserDao {

	void saveUser(User user);
	User findBySSO(String name);
	List<User> findAllUser();
}
