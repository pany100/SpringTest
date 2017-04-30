package com.springtest.account.service;

import java.util.List;

import com.springtest.model.User;

public interface UserManager {
	
	public void saveUser(User u);
	public List<User> getAllUsers();
	void save(User user);
	User findByUsername(String username);

}
