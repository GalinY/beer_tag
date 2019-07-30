package com.beerdemo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beerdemo.demo.models.UserDto;
import com.beerdemo.demo.services.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	
    @PostMapping
    public String loginPage() {
        return "login";
    }
    
}
