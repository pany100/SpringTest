package com.springtest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.springtest.model.Transaction;
import com.springtest.model.User;

@Repository
public class TransactionDAOImpl extends AbstractDAOImpl<Transaction> implements TransactionDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> findAllTransactionsFromUser(User u) {
		Session session = getSessionFactory().openSession();
		Query query= session.
		        createQuery("from Transaction where seller=:u or buyer=:u");
		query.setParameter("u", u);
		List<Transaction> txs = (List<Transaction>) query.list();
		session.close();
		for (Transaction prod : txs) {
			logger.info("Fetching list: " + prod);
		}
		return txs;
		
	}

}
