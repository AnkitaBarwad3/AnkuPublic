package com.app.service;


import com.app.model.User;

public interface UserService
{
	public void saveUser(User user);
	
    public User findOne(Integer id);

    public void delete(Integer id);
    
    public User findByEmailIdAndPassword(String email_Id, String password); 
}
