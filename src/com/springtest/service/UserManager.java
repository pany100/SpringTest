package com.springtest.service;

import java.util.List;

import com.springtest.model.User;

public interface UserManager {
	
	public void saveUser(User u);
	public List<User> getAllUsers();

}
