package com.springtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springtest.dao.UserDAO;
import com.springtest.model.User;

@Service
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserDAO userDao;
	
	@Override
	@Transactional
	public void saveUser(User u) {
		userDao.save(u);
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userDao.list();
	}

}
