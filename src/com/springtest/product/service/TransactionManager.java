package com.springtest.product.service;

import java.util.List;

import com.springtest.model.Product;
import com.springtest.model.Transaction;
import com.springtest.model.User;

public interface TransactionManager {

	public void save(Transaction p);

	public List<Product> findAllProductsTransactionedByUser(User u);

	public void create(Long projectId, User currentUser);	
}
