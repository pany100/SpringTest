package com.springtest.dao;

import java.util.List;

import com.springtest.model.User;

public interface UserDAO {
	
	public void save(User u);
	
	public List<User> list();

}
