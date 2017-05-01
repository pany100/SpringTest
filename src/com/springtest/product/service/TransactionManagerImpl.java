package com.springtest.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtest.dao.ProductDAO;
import com.springtest.dao.TransactionDAO;
import com.springtest.model.Product;
import com.springtest.model.Transaction;
import com.springtest.model.User;

@Service
public class TransactionManagerImpl implements TransactionManager {

	@Autowired
	private TransactionDAO transactionDAO;
	
	@Autowired
	private ProductDAO productDAO; 
	
	@Override
	public void save(Transaction p) {
		transactionDAO.save(p);
	}

	@Override
	public List<Product> findAllProductsTransactionedByUser(User u) {
		return transactionDAO.findAllProductsTransactionedByUser(u);
	}

	@Override
	public void create(Long projectId, User currentUser) {
		Product p = productDAO.findById(projectId);
		Transaction t = new Transaction();
		t.setProduct(p);
		t.setSeller(p.getPublisher());
		t.setBuyer(currentUser);
		transactionDAO.save(t);
	}

}
