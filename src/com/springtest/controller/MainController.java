package com.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springtest.account.service.SecurityService;
import com.springtest.account.service.UserManager;
import com.springtest.account.validator.UserValidator;
import com.springtest.model.User;

@Controller
public class MainController {
	
	@Autowired //this will give you the reference to UserDAO      
	UserManager userService; 
	
	@Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "register";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/index";
    }

	@RequestMapping("/index")  
    public ModelAndView indexWorld() {  
        return new ModelAndView("index");  
    }
	
	@RequestMapping("/404")  
    public ModelAndView error() {  
        return new ModelAndView("404");  
    }
	
}
