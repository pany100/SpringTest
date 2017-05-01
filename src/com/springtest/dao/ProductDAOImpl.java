package com.springtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.springtest.model.Product;
import com.springtest.model.User;

@Repository
public class ProductDAOImpl extends AbstractDAOImpl<Product> implements ProductDAO{

	@Override
	public List<Product> findAllProductsFromUser(User u) {
		List<Product> products = u.getProducts();
		for (Product prod : products) {
			logger.info("Fetching list: " + prod);
		}
		return products;
		
		/* 
		 * SQL IMPL
		 * 
		Session session = getSessionFactory().openSession();
		Query query= session.
		        createQuery("from Product where publisher=:publisher");
		query.setParameter("publisher", u);
		List<Product> products = (List<Product>) query.list();
		session.close();
		for (Product prod : products) {
			logger.info("Fetching list: " + prod);
		}
		return products;
		 * */
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProductsToSell(User u) {
		Session session = getSessionFactory().openSession();
		Query query= session.
		        createQuery("from Product where publisher!=:u");
		query.setParameter("u", u);
		List<Product> products = (List<Product>) query.list();
		session.close();
		for (Product prod : products) {
			logger.info("Fetching list: " + prod);
		}
		return products;
	}
	
}
