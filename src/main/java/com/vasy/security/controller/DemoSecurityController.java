package com.vasy.security.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vasy.security.dto.UsersDto;
import com.vasy.security.service.UserService;

@Controller
public class DemoSecurityController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("Register");
		return modelAndView;
	}
	
	@PostMapping("/register/add")
	public String addUser(UsersDto userDto) {
		this.userService.AddUser(userDto);
		return "redirect:/login";
	}
	
	@GetMapping("/admin")
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView("Admin");
		return modelAndView;
	}
	
	@GetMapping("/user")
	public ModelAndView user() {
		ModelAndView modelAndView = new ModelAndView("User");
		return modelAndView;	
	}
}
