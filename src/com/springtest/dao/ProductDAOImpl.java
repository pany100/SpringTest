package com.springtest.dao;

import java.util.List;

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
	}
	
}
