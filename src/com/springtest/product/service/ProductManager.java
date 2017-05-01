package com.springtest.product.service;

import java.util.List;

import com.springtest.model.Product;
import com.springtest.model.User;

public interface ProductManager {
	
	public void save(Product p);

	public List<Product> findAllProductsFromUser(User u);
	
}