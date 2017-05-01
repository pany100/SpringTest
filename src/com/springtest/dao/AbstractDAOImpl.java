package com.springtest.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAOImpl<T> implements AbstractDAO<T>{

	@Autowired
	private SessionFactory sessionFactory;
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private Class<T> type;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public AbstractDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

	public void save(T model){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(model);
		tx.commit();
		session.close();
		logger.info("Model saved successfully, Details=" + model);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		Session session = this.sessionFactory.openSession();
		List<T> objectList = (List<T>)session.createQuery("from " + type.getSimpleName()).list();
		session.close();
		for (T obj : objectList) {
			logger.info("Fetching list: " + obj);
		}
		return objectList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(Long id) {		
		Session session = getSessionFactory().openSession();
		Query query= session.
		        createQuery("from " + type.getSimpleName() + " where id=:id");
		query.setParameter("id", id);
		T element = (T) query.uniqueResult();
		session.close();
		logger.info("Fetching element: " + element);
		return element;
	}
	
}
