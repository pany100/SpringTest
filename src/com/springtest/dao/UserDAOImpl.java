package com.springtest.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.springtest.model.User;

@Repository
public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO{
	
	@Override
	public User findByUsername(String username) {
		Session session = getSessionFactory().openSession();
		Query query= session.
		        createQuery("from User where username=:username");
		query.setParameter("username", username);
		User user = (User) query.uniqueResult();
		session.close();
		logger.info("Found user: " + user);
		return user;
	}
	
}
