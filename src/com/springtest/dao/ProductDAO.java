package com.springtest.dao;

import java.util.List;

import com.springtest.model.Product;
import com.springtest.model.User;

public interface ProductDAO extends AbstractDAO<Product>{

	List<Product> findAllProductsFromUser(User u);

	List<Product> findAllProductsToSell(User u);

}
