package com.springtest.account.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springtest.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public List<Role> findAll() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Role> roleList = (List<Role>)session.createQuery("from Role").list();
		session.close();
		return roleList;
	}

}
