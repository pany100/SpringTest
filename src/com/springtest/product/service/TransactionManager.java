package com.springtest.product.service;

import java.util.List;

import com.springtest.model.Product;
import com.springtest.model.Transaction;
import com.springtest.model.User;

public interface TransactionManager {

	public void save(Transaction p);

	public List<Transaction> findAllTransactionsFromUser(User u);

	public void create(Product product, User currentUser);	
}
