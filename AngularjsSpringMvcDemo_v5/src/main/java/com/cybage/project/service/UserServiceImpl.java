package com.cybage.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.project.dao.UserDao;
import com.cybage.project.model.User;

/*
 * Indicates that an annotated class is a "Service", originally defined by Domain-Driven Design (Evans, 2003) as 
 * "an operation offered as an interface that stands alone in the model, with no encapsulated state."
 * Describes transaction attributes on a method or class.
 * @see     org.springframework.stereotype.Service
 * @see     org.springframework.transaction.annotation.Transactional
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	/*
     * Marks a constructor, field, setter method or config method as to be autowired by Spring's dependency injection facilities.
     * @see      org.springframework.beans.factory.annotation.Autowired  
     */
	@Autowired
	UserDao userDao;
	
	@Override
	public void saveUser(User user) {		
		userDao.saveUser(user);
	}

	@Override
	public List<User> listAllUser() {
		return userDao.findAllUser();
	}

	@Override
	public User findUserBySSO(String name) {
		
		return userDao.findBySSO(name);
	}

}
