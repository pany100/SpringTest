package com.springtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springtest.dao.UserDAO;
import com.springtest.model.User;

@Controller
public class MainController {
	
	@Autowired //this will give you the reference to UserDAO      
	UserDAO userDao; 

	@RequestMapping("/hello")  
    public ModelAndView helloWorld() {  
        String message = "Hello World, Spring MVC @ Javatpoint";  
        return new ModelAndView("hello", "message", message);  
    }
	
	@RequestMapping("/contact")  
    public ModelAndView contact() {
		List<User> list = userDao.list();
        return new ModelAndView("contact", "eList", list);  
    }
	
}
