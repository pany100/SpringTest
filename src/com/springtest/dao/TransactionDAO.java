package com.springtest.dao;

import java.util.List;

import com.springtest.model.Transaction;
import com.springtest.model.User;

public interface TransactionDAO extends AbstractDAO<Transaction> {

	public List<Transaction> findAllTransactionsFromUser(User u);

}
