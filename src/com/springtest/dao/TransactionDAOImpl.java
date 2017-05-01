package com.springtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.springtest.model.Product;
import com.springtest.model.Transaction;
import com.springtest.model.User;

@Repository
public class TransactionDAOImpl extends AbstractDAOImpl<Transaction> implements TransactionDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProductsTransactionedByUser(User u) {
		Session session = getSessionFactory().openSession();
		Query query= session.
		        createQuery("from Product where seller= : u or buyer = :u");
		query.setParameter("u", u);
		List<Product> products = (List<Product>) query.list();
		session.close();
		for (Product prod : products) {
			logger.info("Fetching list: " + prod);
		}
		return products;
		
	}

}
