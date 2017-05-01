package com.springtest.product.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springtest.common.service.ImagePersister;
import com.springtest.dao.ProductDAO;
import com.springtest.model.Product;
import com.springtest.model.User;

@Service
public class ProductManagerImpl implements ProductManager{

	@Autowired
	private ProductDAO productDao;
	
	@Autowired
	private ImagePersister imagePersister;
	
	@Override
	@Transactional
	public void save(Product p) {
		if (p.getImageFile() != null) {
			String imageName = imagePersister.fileUpload(p.getImageFile());
			p.setImage(imageName);
		}
		this.productDao.save(p);
	}

	@Override
	@Transactional
	public List<Product> findAllProductsFromUser(User u) {
		return productDao.findAllProductsFromUser(u);
	}

	@Override
	@Transactional
	public List<Product> findAllProductsToSell(User u) {
		return productDao.findAllProductsToSell(u);
	}

	@Override
	@Transactional
	public void create(String name, Long price, MultipartFile file, User loggedUser) {
		Product p = new Product();
    	p.setImageFile(file);	
        p.setName(name);
        p.setPrice(price);
        p.setSold(Boolean.FALSE);
        p.setPublisher(loggedUser);
        productDao.save(p);
	}

}
