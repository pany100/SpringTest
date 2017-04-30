package com.springtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springtest.model.User;
import com.springtest.service.UserManager;

@Controller
public class MainController {
	
	@Autowired //this will give you the reference to UserDAO      
	UserManager userService; 
	
	@RequestMapping("/")  
    public ModelAndView login() {  
        return new ModelAndView("login"); 
    }

	@RequestMapping(value = "/register")
    public ModelAndView register(Model model) {
		model.addAttribute("user", new User());
		return new ModelAndView("register");
    }
	
	@RequestMapping(value = "/addUser", method = {RequestMethod.POST})
    public ModelAndView addUser(User u) {
		userService.saveUser(u);
		return new ModelAndView("redirect:/");
    }
	
	@RequestMapping("/hello")  
    public ModelAndView helloWorld() {  
        String message = "Hello World, Spring MVC @ Javatpoint";  
        return new ModelAndView("hello", "message", message);  
    }
	
	@RequestMapping("/contact")  
    public ModelAndView contact() {
		List<User> list = userService.getAllUsers();
        return new ModelAndView("contact", "eList", list);  
    }
	
}
