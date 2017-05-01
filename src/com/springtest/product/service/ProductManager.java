package com.springtest.product.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springtest.model.Product;
import com.springtest.model.User;

public interface ProductManager {
	
	public void save(Product p);

	public List<Product> findAllProductsFromUser(User u);

	public List<Product> findAllProductsToSell(User u);

	public void create(String name, Long price, MultipartFile files, User loggedUser);

	public Product findById(Long projectId);
	
}
