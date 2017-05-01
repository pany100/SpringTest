package com.springtest.dao;

import java.util.List;

public interface AbstractDAO<T> {

	public void save(T object);
	
	public List<T> findAll();
	
}
