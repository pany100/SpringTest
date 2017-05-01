package com.springtest.product.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtest.dao.TransactionDAO;
import com.springtest.model.Product;
import com.springtest.model.Transaction;
import com.springtest.model.User;

@Service
public class TransactionManagerImpl implements TransactionManager {

	@Autowired
	private TransactionDAO transactionDAO;

	@Override
	public void save(Transaction t) {
		transactionDAO.save(t);
	}

	@Override
	@Transactional
	public List<Product> findAllProductsTransactionedByUser(User u) {
		return transactionDAO.findAllProductsTransactionedByUser(u);
	}

	@Override
	@Transactional
	public void create(Product product, User currentUser) {
		Transaction t = new Transaction();
		t.setProduct(product);
		t.setSeller(product.getPublisher());
		t.setBuyer(currentUser);
		this.save(t);
	}

}
