package com.springtest.account.dao;

import com.springtest.model.User;

public interface UserDAO extends AbstractDAO<User>{
	
	public User findByUsername(String username);

}
