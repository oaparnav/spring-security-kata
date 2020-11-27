package com.kata.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityController {
	
	
	@GetMapping("/sayHello")
	public String getData() {
		
		return "Hello";
		
	}

}
