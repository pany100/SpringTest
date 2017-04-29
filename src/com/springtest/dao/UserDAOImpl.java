package com.springtest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springtest.model.User;

public class UserDAOImpl implements UserDAO{
	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public void save(User p){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> list(){
		Session session = this.sessionFactory.openSession();
		List<User> personList = (List<User>)session.createQuery("from User").list();
		session.close();
		return personList;
	}
	
}
