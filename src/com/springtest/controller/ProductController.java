package com.springtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springtest.account.service.SecurityService;
import com.springtest.model.Product;
import com.springtest.product.service.ProductManager;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductManager productService;
	
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
		return "list";
    }
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
    public String product(Model model) {
        return "new";
    }
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
    public String product(@RequestParam("name") String[] names,
			@RequestParam("imageFile") MultipartFile[] files,
			@RequestParam("price") Long[] price) {
		
        Product p = new Product();
        if (files.length > 0) {
        	p.setImageFile(files[0]);	
        }
        p.setName(names[0]);
        p.setPrice(price[0]);
        p.setPublisher(securityService.getLoggedUser());
        productService.save(p);
        
        return "redirect:myProducts";

    }
	
	@RequestMapping(value = "/myProducts", method = RequestMethod.GET)
    public String myProduct(Model model) {
		List<Product> product = productService.findAllProductsFromUser(securityService.getLoggedUser());
		model.addAttribute("myProducts", product);
		return "myProducts";

    }
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
    public String history(Model model) {
        return "history";
    }

}
