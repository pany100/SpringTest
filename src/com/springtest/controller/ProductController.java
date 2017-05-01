package com.springtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springtest.account.service.SecurityService;
import com.springtest.model.Product;
import com.springtest.product.service.ProductManager;
import com.springtest.product.service.TransactionManager;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductManager productService;
	
	@Autowired
	private TransactionManager transactionManager;
	
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping(value = "/productsToBuy", method = RequestMethod.GET)
    public String list(Model model) {
		List<Product> product = productService.findAllProductsToSell(securityService.getLoggedUser());
		model.addAttribute("products", product);
		return "productsToBuy";
    }
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
    public String product(Model model) {
        return "new";
    }
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
    public String product(@RequestParam("name") String[] names,
			@RequestParam("imageFile") MultipartFile[] files,
			@RequestParam("price") Long[] price) {
		
        //TODO Add validations to this post
        productService.create(names[0], price[0], files[0], securityService.getLoggedUser());
        
        return "redirect:myProducts";

    }
	
	@RequestMapping(value = "/myProducts", method = RequestMethod.GET)
    public String myProduct(Model model) {
		List<Product> product = productService.findAllProductsFromUser(securityService.getLoggedUser());
		model.addAttribute("products", product);
		return "myProducts";
    }
	
	@RequestMapping(value = "/buy/{projectId}", method = RequestMethod.POST)
	public String buy(@PathVariable("projectId") Long projectId) {
		Product p = productService.findById(projectId);
		transactionManager.create(p, securityService.getLoggedUser());
		
		return "index";
	}
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
    public String history(Model model) {
        return "history";
    }

}
