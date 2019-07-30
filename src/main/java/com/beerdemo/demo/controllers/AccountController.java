package com.beerdemo.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beerdemo.demo.models.UserDto;
import com.beerdemo.demo.services.UserService;

@RestController
@RequestMapping("/account/")
public class AccountController {
	@Autowired
	private UserService userService;
	
    @PostMapping("/registration")
    public String registration(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return "ok";
    }
}
