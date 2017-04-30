package com.springtest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springtest.model.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public void save(User u){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(u);
		tx.commit();
		session.close();
		logger.info("User saved successfully, User Details=" + u);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> list(){
		Session session = this.sessionFactory.openSession();
		List<User> userList = (List<User>)session.createQuery("from User").list();
		session.close();
		for (User user : userList) {
			logger.info("Person list: " + user);
		}
		return userList;
	}
	
}
