package com.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
		return "list";
    }
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
    public String product(Model model) {
       return "new";
    }
	@RequestMapping(value = "/history", method = RequestMethod.GET)
    public String history(Model model) {
        return "history";
    }

}
