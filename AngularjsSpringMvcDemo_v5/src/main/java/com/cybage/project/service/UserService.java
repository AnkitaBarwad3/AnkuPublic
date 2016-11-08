package com.cybage.project.service;

import java.util.List;

import com.cybage.project.model.User;

public interface UserService {

	void saveUser(User user);
	List<User> listAllUser();
	User findUserBySSO(String name);
	
}
