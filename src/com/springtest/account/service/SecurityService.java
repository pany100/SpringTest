package com.springtest.account.service;

import com.springtest.model.User;

public interface SecurityService {
	
	public String findLoggedInUsername();
	
	public void autologin(String username, String password);
	
	public User getLoggedUser();

}
